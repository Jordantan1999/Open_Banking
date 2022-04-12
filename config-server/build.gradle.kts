/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
 id("org.springframework.boot") version "2.6.6"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.10"
  kotlin("plugin.spring") version "1.6.10"
  kotlin("plugin.jpa") version "1.6.10"
}

group = "com.bank"
version = "0.0.1-SNAPSHOT"
description = "config-server"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
	mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

extra["springCloudVersion"] = "2021.0.1"

dependencies {
    implementation("org.springframework.cloud:spring-cloud-config-server:3.1.1")
	implementation("pl.allegro.tech.build:axion-release-plugin:1.13.6")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.6")
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
  }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
	useJUnitPlatform()
}