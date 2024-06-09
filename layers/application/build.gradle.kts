dependencies {
    //TODO implementation("org.springframework:spring-context:${dependencyManagement.managedVersions["org.springframework:spring-context"]}")
    //implementation(provider { """org.springframework:spring-context:${dependencyManagement.managedVersions["org.springframework:spring-context"]}""" })
    //implementation(provider { """org.springframework:spring-context:${dependencyManagement.importedProperties["spring-framework.version"]}""" })
    //implementation(provider { """org.springframework:spring-context:${dependencyManagement.importedProperties["spring.version"]}""" })
    implementation("org.springframework:spring-context:6.1.8")
    implementation(project(":api"))
    implementation(project(":domain"))
}
