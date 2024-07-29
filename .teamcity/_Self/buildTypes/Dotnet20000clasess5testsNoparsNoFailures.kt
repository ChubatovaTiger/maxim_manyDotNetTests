package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object Dotnet20000clasess5testsNoparsNoFailures : BuildType({
    name = "dotnet   20000clasess5testsNopars_noFailures"

    artifactRules = "+:%teamcity.agent.home.dir%/temp/agentTmp/*runsettings=>."

    params {
        param("teamcity.internal.dotnet.test.exact.match.filter", "false")
        param("teamcity.internal.dotnet.test.exact.match.filter.size", "10000")
    }

    vcs {
        root(_Self.vcsRoots.ChubatovaNunit6112)
    }

    steps {
        script {
            enabled = false
            scriptContent = "dotnet --version"
        }
        dotnetTest {
            projects = "PrimeServiceTests/PrimeServiceTests.csproj"
            settingsFile = "example.runsettings"
            sdk = "6"
            dockerImage = "mcr.microsoft.com/dotnet/sdk:6.0"
        }
    }

    triggers {
        finishBuildTrigger {
            enabled = false
            buildType = "${Dotnet20000clasess5testsNoparsNoFailures.id}"
            branchFilter = "+:*"

            buildParams {
                param("teamcity.internal.dotnet.test.exact.match.filter", "true")
            }
        }
    }

    features {
        parallelTests {
            numberOfBatches = 3
        }
    }
})
