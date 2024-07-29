package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({

    vcsRoot(ChubatovaNunit6)
    vcsRoot(ChubatovaNunit6111)
    vcsRoot(ChubatovaNunit6112)
    vcsRoot(ChubatovaNunit611)
    vcsRoot(ChubatovaNunit61121)
    vcsRoot(ChubatovaNunit61111)
    vcsRoot(ChubatovaNunit62)
    vcsRoot(ChubatovaNunit61)

    buildType(Dotnet20000clasess5testsNopars)
    buildType(Dotnet10ms2000classesSuccess)
    buildType(Dotnet20000clasess5testsNoparsNoFailures)
    buildType(Dotnet10000classes10tests50ms)
    buildType(Dotnet10ms2000classes)
    buildType(DotnetTest)
    buildType(Dotnet10ms2000classesTestcasefilet)
    buildType(Dotnet100ms)
    buildType(Buildkit)
    buildType(Dotnet100msNoFailures)
    buildType(DotnetDifferentNamespaces)

    template(DefaultTemplateChubatova)

    params {
        param("teamcity.internal.dotnet.test.suppression.test.classes.threshold", "1")
    }

    cleanup {
        keepRule {
            id = "KEEP_RULE_27"
            keepAtLeast = allBuilds()
            dataToKeep = everything()
            applyPerEachBranch = true
            preserveArtifactsDependencies = true
        }
    }

    subProject(Ec2tw81850.Project)
    subProject(KimVMavenSimpleProjectDockerArts.Project)
    subProject(Deployment82870.Project)
    subProject(Slack.Project)
    subProject(CheckParametersTab.Project)
    subProject(MavenTestChubatova.Project)
    subProject(Suppression.Project)
    subProject(Matrix.Project)
    subProject(S3uploadChunkTest.Project)
})
