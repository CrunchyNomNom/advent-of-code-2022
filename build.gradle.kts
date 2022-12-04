plugins {
    kotlin("jvm") version "1.7.22"
    application
}

repositories {
    mavenCentral()
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }

    wrapper {
        gradleVersion = "7.6"
    }
}

application {
    // Define the main class for the application.
    mainClass.set("com.github.crunchynomnom.aoc2022.MainKt")
}
