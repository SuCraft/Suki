pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

rootProject.name = "suki" // Gale - build changes // Suki - build changes

include("suki-api", "suki-server") // Gale - build changes // Suki - build changes
