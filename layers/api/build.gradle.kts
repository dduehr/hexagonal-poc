dependencies {
    //TODO implementation("org.springframework:spring-context:${dependencyManagement.managedVersions["org.springframework:spring-context"]}")
    //implementation(provider { """org.springframework:spring-context:${dependencyManagement.managedVersions["org.springframework:spring-context"]}""" })
    //implementation(provider { """org.springframework:spring-context:${dependencyManagement.importedProperties["spring-framework.version"]}""" })
    //implementation(provider { """org.springframework:spring-context:${dependencyManagement.importedProperties["spring.version"]}""" })
    implementation("org.springframework:spring-context:6.1.8")
    //implementation("jakarta.validation:jakarta.validation-api:3.1.0")
    //implementation("org.hibernate:hibernate-validator:8.0.1.Final")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.3.0")
    implementation(project(":domain"))
}
