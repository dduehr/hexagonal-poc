import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version Versions.springBootPluginVersion apply false
    id("io.spring.dependency-management") version Versions.springDependencyManagementPluginVersion apply false
    id("org.jetbrains.kotlin.jvm") version Versions.kotlinJvmPluginVersion
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlinSpringPluginVersion
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testImplementation("org.assertj:assertj-core:${Versions.assertJVersion}")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = Versions.kotlinJvmTarget
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}





