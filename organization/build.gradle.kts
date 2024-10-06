plugins {
    id("java")
    id("application")
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.diffplug.spotless") version "6.11.0"
}

val springAiVersion = "1.0.0-M2"
val springDocVersion = "2.2.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springdoc:springdoc-openapi-ui:1.8.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    // db
    runtimeOnly("org.postgresql:postgresql")

    // Lombok dependencies
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    // MapStruct dependencies
    implementation("org.mapstruct:mapstruct:1.6.2")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.2")

    // Jakarta dependencies
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("jakarta.json.bind:jakarta.json.bind-api:3.0.1")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

    // JUnit for testing
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

spotless {
    java {
        target("**/*.java")
        googleJavaFormat() // або інші правила форматування
    }
    format("misc") {
        target("**/*.gradle", "**/*.md", "**/*.properties", "**/*.yml", "**/*.yaml")
        indentWithSpaces(4)
    }
}

tasks.test {
    useJUnitPlatform()
}
