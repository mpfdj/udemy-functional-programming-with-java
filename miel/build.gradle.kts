plugins {
    id("java")
}

group = "programming"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}


task("welcome") {
    doLast() {
        println("Welcome to my Gradle task!")
    }
}


// https://www.baeldung.com/gradle-custom-task
abstract class PrintToolVersionTask : DefaultTask() {

    @get: Input
    abstract val tool: Property<String>

    @TaskAction
    fun printToolVersion() {
        when (val t = tool.get()) {
            "java" -> println(System.getProperty("java.version"))
            "kotlin" -> println(KotlinVersion.CURRENT)
            else -> throw IllegalArgumentException("Unknown tool: $t")
        }
    }
}

tasks.register<PrintToolVersionTask>("printJavaVersion") {
    tool.set("java")
}

tasks.register<PrintToolVersionTask>("printKotlinVersion") {
    tool.set("kotlin")
}

tasks.register<PrintToolVersionTask>("printInvalidToolVersion") {
    tool.set("INVALID")
}