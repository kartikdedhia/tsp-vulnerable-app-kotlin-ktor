plugins {
    kotlin("jvm") version "1.6.10"

    application
}

version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("io.ktor:ktor-thymeleaf:1.6.7")

    implementation("ch.qos.logback:logback-classic:1.2.11")
}

tasks.withType<JavaCompile>().configureEach {
    targetCompatibility = "11"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}
