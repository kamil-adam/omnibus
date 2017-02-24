package pl.writeonly.omnibus.main

import com.codahale.metrics.MetricRegistry
import com.google.inject.Guice
import com.google.inject.Injector
import io.dropwizard.Application
import io.dropwizard.jersey.setup.JerseyEnvironment
import io.dropwizard.jetty.setup.ServletEnvironment
import io.dropwizard.lifecycle.setup.LifecycleEnvironment
import io.dropwizard.setup.AdminEnvironment
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.views.ViewBundle
import org.eclipse.jetty.server.Authentication
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature
//import pl.writeonly.omnibus.rest.OmnibusResource

class OmnibusApplication : Application<OmnibusConfiguration>() {

    //  override def getName: String = "getClass"

    override fun initialize(bootstrap: Bootstrap<OmnibusConfiguration>) {
//        logger info "initialize"
//
        bootstrap.addBundle(ViewBundle<OmnibusConfiguration>())
//        bootstrap.addBundle(ViewBundle<OmnibusConfiguration>() {
//            override fun getViewConfiguration(c: OmnibusConfiguration): Map[String, Map[String, String]] = {
//            return super.getViewConfiguration(c)
//        }
//        })

        //    bootstrap.addCommand(new ScalareCommand())
    }


    override fun run(c: OmnibusConfiguration?, e: Environment?) {
//        logger info "run"
        if (c != null && e != null) {
            val i = Guice.createInjector(OmnibusModule(c, e))
            run(i, e)
        }
    }

    private fun run(i: Injector, e: Environment) {
        //environment
        run(i, e.jersey())
        run(i, e.lifecycle())
        run(i, e.servlets())
        run(i, e.admin())
        //metric
//        run(i, e.healthChecks())
        run(i, e.metrics())
        //other
        //    e.jersey().register(new IllegalArgumentExceptionMapper(e.metrics()));
        //    e.jersey().register(new Resource());

    }

    private fun run(i: Injector, e: JerseyEnvironment) {

//        e.register(i.getInstance(javaClass<AuthDynamicFeature>()))
//        e.register(javaClass<RolesAllowedDynamicFeature>);
//        If you want to use @Auth to inject a custom Principal type into your resource
//        e.register(AuthValueFactoryProvider.Binder(classOf[Authentication.User]));

        //
        //e.register(i.getInstance(classOf[ScalareResource]))
//        e.register(i.getInstance(classOf[DatabaseResource]))
//        e.register(i.getInstance(classOf[TaskResource]))
//        e.register(i.getInstance(classOf[HealthCheckResource]))
//        e.register(i.getInstance(classOf[EventResource]))
//        e.register(i.getInstance(javaClass<OmnibusResource>()))

    }

    private fun run(i: Injector, e: AdminEnvironment) {
//        e.addTask(i.getInstance(classOf[TruncateTask]))
    }

    private fun run(i: Injector, e: LifecycleEnvironment)  {

    }

    private fun run(i: Injector, e: ServletEnvironment)  {

    }

    private fun run(i: Injector, e: MetricRegistry) {
    }

//    private fun run(i: Injector, e: HealthCheckRegistry) {
////        e.register("event", i.getInstance(classOf[EventHealthCheck]))
////        e.register("template", i.getInstance(classOf[TemplateHealthCheck]))
////        e.register("sqlite", i.getInstance(classOf[SQLiteHealthCheck]))
////        val repo = i.getInstance(classOf[HealthCheckRepo])
////        logger.info("runHealthChecks" + repo.runHealthChecks)
//
//    }

}