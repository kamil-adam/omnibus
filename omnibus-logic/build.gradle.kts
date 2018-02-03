plugins {
    kotlin("jvm")
    id("com.cursive-ide.clojure")
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.clojure:clojure:1.9.0")
    compile("org.clojure:core.logic:0.8.11")
}
