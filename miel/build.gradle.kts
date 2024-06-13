import com.adarshr.gradle.testlogger.theme.ThemeType


plugins {
    id("java")
    id("com.adarshr.test-logger") version "4.0.0"
    id("application")
}

group = "programming"
version = "1.0-SNAPSHOT"

application {
    mainClass = "programming.FP01Functional"
}

tasks.jar {
    manifest.attributes["Main-Class"] = application.mainClass
}


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    reports.junitXml.required = false
    reports.html.required = false
//    testLogging.showStandardStreams = true
}

testlogger {
    theme = ThemeType.STANDARD
    showExceptions = false
    showStackTraces = false
    showFullStackTraces = false
    showCauses = false
    slowThreshold = 2000
    showSummary = false
    showSimpleNames = false
    showPassed = true
    showSkipped = true
    showFailed = true
    showOnlySlow = false
    showStandardStreams = false
    showPassedStandardStreams = false
    showSkippedStandardStreams = false
    showFailedStandardStreams = false
    logLevel = LogLevel.LIFECYCLE
}


apply("task-welcome.gradle.kts")
apply("task-print-version.gradle.kts")
