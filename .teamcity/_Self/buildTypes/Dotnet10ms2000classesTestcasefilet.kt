package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object Dotnet10ms2000classesTestcasefilet : BuildType({
    name = "dotnet 10ms_2000classes testcasefilter"

    params {
        param("teamcity.internal.dotnet.test.exact.match.filter", "false")
        param("teamcity.internal.dotnet.test.exact.match.filter.size", "10000")
    }

    vcs {
        root(_Self.vcsRoots.ChubatovaNunit6)
    }

    steps {
        script {
            enabled = false
            scriptContent = "dotnet --version"
        }
        dotnetTest {
            projects = "PrimeServiceTests/PrimeServiceTests.csproj"
            filter = "FullyQualifiedName!~CheckAssumeCase10_1111"
            sdk = "6"
            dockerImage = "mcr.microsoft.com/dotnet/sdk:6.0"
        }
    }

    triggers {
        finishBuildTrigger {
            enabled = false
            buildType = "${Dotnet10ms2000classesTestcasefilet.id}"
            branchFilter = "+:*"

            buildParams {
                param("teamcity.internal.dotnet.test.exact.matcteamcity.internal.dotnet.test.exact.match.filter.sizeh.filter.size", "25000")
            }
        }
    }

    features {
        parallelTests {
            numberOfBatches = 3
        }
    }
})
