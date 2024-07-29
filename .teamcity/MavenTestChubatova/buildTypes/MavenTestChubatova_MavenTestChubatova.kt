package MavenTestChubatova.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.buildCache
import jetbrains.buildServer.configs.kotlin.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven

object MavenTestChubatova_MavenTestChubatova : BuildType({
    name = "mavenTestChubatova"

    params {
        param("teamcity.internal.feature.build.cache.enabled", "true")
    }

    vcs {
        root(MavenTestChubatova.vcsRoots.MavenTestChubatova_ChubatovaMavenSample)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true -Dmaven.repo.local=%teamcity.build.checkoutDir%/.m2"
            localRepoScope = MavenBuildStep.RepositoryScope.MAVEN_DEFAULT
        }
    }

    features {
        buildCache {
            name = "mavenCacheChubatova"
            publishOnlyChanged = false
            rules = ".m2"
        }
    }
})
