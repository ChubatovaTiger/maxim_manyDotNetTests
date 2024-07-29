package KimVMavenSimpleProjectDockerArts.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object KimVMavenSimpleProjectDockerArts_Build : BuildType({
    name = "Build"

    artifactRules = "*.hprof => java_pidxxx.hprof.7z"

    params {
        param("mavendockerimagechubatova", "adoptopenjdk/maven-openjdk11")
    }

    vcs {
        root(KimVMavenSimpleProjectDockerArts.vcsRoots.KimVMavenSimpleProjectDockerArts_SshGitGitJetbrainsTeamTeamcityBuildToolsIntegrationsMavenSimpleProjectGitRefsHeadsMain)
    }

    steps {
        maven {
            name = "Maven Test Step"
            enabled = false
            goals = "clean test"
        }
        maven {
            name = "Maven Test Step Docker"
            goals = "clean test"
            dockerImage = "%mavendockerimagechubatova%"
        }
    }

    triggers {
        vcs {
            enabled = false
        }
    }

    features {
        perfmon {
        }
    }
})
