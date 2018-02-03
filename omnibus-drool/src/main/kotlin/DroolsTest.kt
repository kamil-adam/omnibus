package com.sample

import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer
import org.kie.api.runtime.KieSession

/**
 * This is a sample class to launch a rule.
 */
object DroolsTest {

 @JvmStatic  fun main(args:Array<String>) {
  try
  {
   // load up the knowledge base
   val ks = KieServices.Factory.get()
   val kContainer = ks.getKieClasspathContainer()
   val kSession = kContainer.newKieSession("ksession-rules")

   // go !
   val message = Message()
   message.message = "Hello World"
   message.status = Message.HELLO
   kSession.insert(message)
   kSession.fireAllRules()
  }
  catch (t:Throwable) {
   t.printStackTrace()
  }

 }

 class Message {

  var message:String? = null

  var status:Int = 0

  companion object {

   val HELLO = 0
   val GOODBYE = 1
  }

 }

}