plugins {
    kotlin("jvm")
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.drools:drools-compiler:7.5.0.Final")
    compile("org.drools:drools-core:7.5.0.Final")
    compile("org.drools:drools-decisiontables:7.5.0.Final")
    compile("org.kie:kie-api:7.5.0.Final")
    compile("org.kie:kie-internal:7.5.0.Final")
}
