plugins {
    kotlin("jvm")
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.scala-lang:scala-library:2.12.4")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.8.8")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-properties:2.8.8")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.8.8")
}