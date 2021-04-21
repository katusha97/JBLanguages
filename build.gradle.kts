plugins {
    kotlin("jvm") version "1.4.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

kotlin {
    sourceSets {
        main {
            kotlin.setSrcDirs(listOf("src/main"))
        }
        test {
            kotlin.setSrcDirs(listOf("src/test"))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}