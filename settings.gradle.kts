rootProject.name = "hexagonal-poc"

include("framework")

File(rootDir, "layers").listFiles()?.forEach {
    val layer = it.name
    include(layer)
    project(":$layer").projectDir = file("layers/$layer")
}
