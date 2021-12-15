plugins {
    application
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "com.metehanbolat"
version = "0.0.1"

application {
    mainClass.set("com.metehanbolat.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-server-core:1.6.6")
    implementation("io.ktor:ktor-server-netty:1.6.6")
    implementation("ch.qos.logback:logback-classic:1.2.8")
    implementation("io.ktor:ktor-serialization:1.6.6")

}