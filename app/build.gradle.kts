plugins {
    application
    id("com.github.ben-manes.versions") version "0.53.0"
    id("org.sonarqube") version "7.1.0.6387"
    checkstyle
}

application {
    mainClass = "hexlet.code.App"

}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.20.0")
}

sonar {
    properties {
        property("sonar.projectKey", "AnaniOganesian_java-project-61")
        property("sonar.organization", "ananioganesian")
    }
}