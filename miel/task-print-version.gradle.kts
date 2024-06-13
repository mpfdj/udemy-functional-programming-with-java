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