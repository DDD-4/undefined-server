import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.72"
    id("com.google.cloud.tools.jib") version "2.5.0"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}

group = "com.undefined"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

ext {
    set("springCloudVersion", "Hoxton.SR6")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Greenwich.SR3")
    }
}

dependencies {
    implementation("com.expediagroup", "graphql-kotlin-spring-server", "3.6.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.cloud:spring-cloud-starter-aws-parameter-store-config")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

jib {
    from {
        image = "adoptopenjdk/openjdk11"
    }
    to {
        image = "010873464532.dkr.ecr.ap-northeast-2.amazonaws.com/repo-platz"
        tags = setOf("latest", "${project.name}-${project.version}")
    }
    container {
        creationTime = "USE_CURRENT_TIMESTAMP"
        jvmFlags = listOf("-Dspring.profiles.active=dev", "-XX:+UseContainerSupport", "-Dserver.port=8080", "-Dfile.encoding=UTF-8")
        ports = listOf("8080")
        labels = mapOf("maintainer" to "yoon.homme <woosiks.io@gmail.com>")
        user = "nobody:nogroup"
    }
}
