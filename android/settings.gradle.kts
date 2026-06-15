pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DS-SaaS"
include(":app")
include(":data")
include(":domain")
include(":core:common")
include(":core:network")

