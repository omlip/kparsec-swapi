plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization") version "2.1.21"
    //id("io.ktor.plugin") version "3.2.3"
}

group = "be.olan"
version = "1.0-SNAPSHOT"

val logbackVersion: String by project
val kotlinxDatetimeVersion: String by project
val ktorVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation("io.ktor:ktor-client-mock:$ktorVersion")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    sourceSets.all {
        languageSettings.optIn("kotlin.time.ExperimentalTime")
    }
    jvmToolchain(21)
}
