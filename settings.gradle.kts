rootProject.name = "hexagonal-poc"

include("framework")

arrayOf("adapter", "api", "application", "domain").forEach {
    include(it)
    project(":$it").projectDir = file("layers/$it")
}
