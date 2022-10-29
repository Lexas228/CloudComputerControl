plugins {
    id("java")
    id("org.springframework.boot") version "2.7.5"
}


group = "ru.idea.ccc"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.devh:grpc-spring-boot-starter:2.13.1.RELEASE")
    implementation(project(":user-servie-grpc"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}