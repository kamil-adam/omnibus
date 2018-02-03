(ns simple-typed-lambda-calculus
   (:refer-clojure :exclude [==])
   (:use clojure.core.logic))

(defna findo [x l o]
  ([_ [[y :- o] . _] _]
    (project [x y] (== (= x y) true)))
  ([_ [_ . c] _] (findo x c o)))

(defn typedo [c x t]
  (conda
    [(lvaro x) (findo x c t)]
    [(matche [c x t]
       ([_ [[y] :>> a] [s :> t]]
          (fresh [l]
            (conso [y :- s] c l)
            (typedo l a t)))
       ([_ [:apply a b] _]
          (fresh [s]
            (typedo c a [s :> t])
            (typedo c b s))))]))

(comment
  ;; ([_.0 :> _.1])
  (run* [q]
    (fresh [f g a b t]
     (typedo [[f :- a] [g :- b]] [:apply f g] t)
     (== q a)))

  ;; ([:int :> _.0])
  (run* [q]
    (fresh [f g a t]
     (typedo [[f :- a] [g :- :int]] [:apply f g] t)
     (== q a)))

  ;; (:int)
  (run* [q]
    (fresh [f g a t]
     (typedo [[f :- [:int :> :float]] [g :- a]]
       [:apply f g] t)
     (== q a)))

  ;; ()
  (run* [t]
    (fresh [f a b]
      (typedo [f :- a] [:apply f f] t)))

  ;; ([_.0 :> [[_.0 :> _.1] :> _.1]])
  (run* [t]
    (fresh [x y]
      (typedo []
        [[x] :>> [[y] :>> [:apply y x]]] t)))
  )