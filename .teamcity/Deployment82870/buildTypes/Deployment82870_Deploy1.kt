package Deployment82870.buildTypes

import jetbrains.buildServer.configs.kotlin.*

object Deployment82870_Deploy1 : BuildType({
    name = "deploy1"

    enablePersonalBuilds = false
    type = BuildTypeSettings.Type.DEPLOYMENT
    maxRunningBuilds = 1

    vcs {
        root(Deployment82870.vcsRoots.Deployment82870_ChubatovaSampleGradleTests)
    }

    dependencies {
        snapshot(Deployment82870_Build1) {
        }
    }
})
