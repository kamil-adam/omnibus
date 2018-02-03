import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.1.51" apply false
    scala
    jacoco
    idea
    checkstyle
    pmd
    findbugs
    `scala-lang`
    maven
    `scala-base`
}

allprojects {

    group = "org.gradle.kotlin.dsl.samples.multiprojectci"

    version = "1.0"

    repositories {
        jcenter()
    }
}

// Configure all KotlinCompile tasks on each sub-project
subprojects {

    tasks.withType<KotlinCompile> {
        println("Configuring $name in project ${project.name}...")
        kotlinOptions {
            suppressWarnings = true
        }
    }
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
