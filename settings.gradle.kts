import java.util.Locale

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

if (!file(".git").exists()) {
    // Suki start - build changes
    val errorText = """
        
        =====================[ ERROR ]=====================
         The Suki project directory is not a properly cloned Git repository.
         
         In order to build Suki from source you must clone
         the Suki repository using Git, not download a code
         zip from GitHub.
         
         Built Suki jars are available for download at
         https://github.com/SuCraft/Suki/actions
         
         See https://github.com/PaperMC/Paper/blob/master/CONTRIBUTING.md
         for further information on building and modifying Paper forks.
        ===================================================
    """.trimIndent()
    // Suki end - build changes
    error(errorText)
}

rootProject.name = "suki" // Suki - build changes

for (name in listOf("suki-api", "suki-server")) { // Suki - build changes
    val projName = name.lowercase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")!!.projectDir = file(name)
}