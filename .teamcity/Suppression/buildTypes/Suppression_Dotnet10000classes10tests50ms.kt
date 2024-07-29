package Suppression.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object Suppression_Dotnet10000classes10tests50ms : BuildType({
    name = "dotnet  10000classes10tests50ms"

    params {
        param("teamcity.internal.dotnet.test.suppression", "true")
    }

    vcs {
        root(_Self.vcsRoots.ChubatovaNunit61)
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
            buildType = "${Suppression_Dotnet10000classes10tests50ms.id}"
            branchFilter = "+:*"
        }
    }

    features {
        parallelTests {
            numberOfBatches = 3
        }
    }
})
