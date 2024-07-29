package Deployment82870

import Deployment82870.buildTypes.*
import Deployment82870.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("Deployment82870")
    name = "deployment82870"

    vcsRoot(Deployment82870_ChubatovaSampleGradleTests)

    buildType(Deployment82870_Build1)
    buildType(Deployment82870_Deploy1)
})
