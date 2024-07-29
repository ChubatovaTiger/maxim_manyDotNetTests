package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object Dotnet100ms : BuildType({
    name = "dotnet  100ms"

    params {
        param("teamcity.internal.dotnet.test.exact.match.filter", "false")
        param("teamcity.internal.dotnet.test.exact.match.filter.size", "10000")
    }

    vcs {
        root(_Self.vcsRoots.ChubatovaNunit61111)
    }

    steps {
        script {
            enabled = false
            scriptContent = "dotnet --version"
        }
        dotnetTest {
            projects = "PrimeServiceTests/PrimeServiceTests.csproj"
            sdk = "6"
            dockerImage = "mcr.microsoft.com/dotnet/sdk:6.0"
        }
    }

    triggers {
        finishBuildTrigger {
            enabled = false
            buildType = "${Dotnet100ms.id}"
            branchFilter = "+:*"

            buildParams {
                param("teamcity.internal.dotnet.test.exact.match.filter", "true")
                param("teamcity.internal.dotnet.test.exact.match.filter.size", "25000")
            }
        }
    }

    features {
        parallelTests {
            numberOfBatches = 10
        }
    }
})
