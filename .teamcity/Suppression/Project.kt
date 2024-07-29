package Suppression

import Suppression.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("Suppression")
    name = "Suppression"

    buildType(Suppression_Dotnet10000classes10tests50ms)
})
