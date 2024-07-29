package Deployment82870.buildTypes

import jetbrains.buildServer.configs.kotlin.*

object Deployment82870_Build1 : BuildType({
    name = "build1"

    vcs {
        root(Deployment82870.vcsRoots.Deployment82870_ChubatovaSampleGradleTests)
    }
})
