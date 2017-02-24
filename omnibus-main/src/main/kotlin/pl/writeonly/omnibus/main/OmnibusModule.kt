package pl.writeonly.omnibus.main

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.views.ViewBundle

class OmnibusModule (val c: OmnibusConfiguration, val e: Environment) : AbstractModule() {
    override fun configure() {

    }
}