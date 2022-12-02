plugins {
    kotlin("jvm") version "1.7.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
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
    mainClass.set("com.github.crunchynomnom.aoc2022.main")
}
