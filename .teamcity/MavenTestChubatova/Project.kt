package MavenTestChubatova

import MavenTestChubatova.buildTypes.*
import MavenTestChubatova.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("MavenTestChubatova")
    name = "mavenTestChubatova"

    vcsRoot(MavenTestChubatova_ChubatovaMavenSample)

    buildType(MavenTestChubatova_MavenTestChubatova)

    params {
        param("teamcity.internal.feature.build.cache.enabled", "true")
    }
})
