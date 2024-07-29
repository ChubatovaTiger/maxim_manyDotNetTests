package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object Dotnet20000clasess5testsNopars : BuildType({
    name = "dotnet   20000clasess5testsNopars"

    params {
        param("teamcity.internal.dotnet.test.exact.match.filter", "false")
        param("hm", """
            There are 0 own parameters defined and 2 inherited
            Configuration Parameters
            Configuration parameters are not passed into build, can be used in references only. 
            System Properties (system.)
            System properties will be accessible without the system. prefix in some of the build runners. 
            None defined
            
            Environment Variables (env.)
            Environment variables will be added to the environment of the processes launched by the build runner (without env. prefix). 
            There are 0 own parameters defined and 2 inherited
            Configuration Parameters
            Configuration parameters are not passed into build, can be used in references only. 
            System Properties (system.)
            System properties will be accessible without the system. prefix in some of the build runners. 
            None defined
            
            Environment Variables (env.)
            Environment variables will be added to the environment of the processes launched by the build runner (without env. prefix). 
            There are 0 own parameters defined and 2 inherited
            Configuration Parameters
            Configuration parameters are not passed into build, can be used in references only. 
            System Properties (system.)
            System properties will be accessible without the system. prefix in some of the build runners. 
            None defined
            
            Environment Variables (env.)
            Environment variables will be added to the environment of the processes launched by the build runner (without env. prefix).
        """.trimIndent())
        param("teamcity.internal.dotnet.test.exact.match.filter.size", "10000")
    }

    vcs {
        root(_Self.vcsRoots.ChubatovaNunit611)
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
            buildType = "${Dotnet20000clasess5testsNopars.id}"
            branchFilter = "+:*"

            buildParams {
                param("teamcity.internal.dotnet.test.exact.match.filter", "true")
                param("teamcity.internal.dotnet.test.exact.match.filter.size", "25000")
            }
        }
    }

    features {
        parallelTests {
            numberOfBatches = 3
        }
    }
})
