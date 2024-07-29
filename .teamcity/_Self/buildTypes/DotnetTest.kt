package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object DotnetTest : BuildType({
    name = "dotnet test very fast tests"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            enabled = false
            scriptContent = "dotnet --version"
        }
        dotnetTest {
            projects = "NUnit/NUnit.sln"
            sdk = "6"
            dockerImage = "mcr.microsoft.com/dotnet/sdk:6.0"
        }
    }

    triggers {
        finishBuildTrigger {
            enabled = false
            buildType = "${DotnetTest.id}"
            branchFilter = "+:*"

            buildParams {
                param("teamcity.internal.dotnet.test.exact.match.filter", "true")
                param("teamcity.internal.dotnet.test.exact.match.filter.size", "25000")
            }
        }
    }

    features {
        parallelTests {
            enabled = false
            numberOfBatches = 3
        }
    }
})
