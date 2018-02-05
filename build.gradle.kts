import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    mavenCentral()
    jcenter()
    maven("http://clojars.org/repo")
}

plugins {
    base
    kotlin("jvm") version "1.1.51" apply false
    id("com.diffplug.gradle.spotless") version "3.8.0"
    id("com.cursive-ide.clojure") version "1.1.0"
    id("com.moowork.node") version "1.2.0"
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
