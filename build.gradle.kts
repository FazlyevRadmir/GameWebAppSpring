plugins {
    id("java")
    id("org.springframework.boot") version "2.7.8"
}

apply(plugin = "io.spring.dependency-management")

group = "com.fazlyev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.springframework.boot:spring-boot-starter-freemarker")

    // FreeMarker (.ftl)
    implementation("org.webjars:jquery:3.6.0")
    implementation("org.webjars:bootstrap:5.0.1")

    // Spring Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("org.springframework.boot:spring-boot-starter-web:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-freemarker")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.postgresql:postgresql:42.5.3")
    compileOnly("org.projectlombok:lombok:1.18.24")


    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}