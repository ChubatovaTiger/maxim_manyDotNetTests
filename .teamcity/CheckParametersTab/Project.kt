package CheckParametersTab

import CheckParametersTab.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("CheckParametersTab")
    name = "checkParametersTab"

    buildType(CheckParametersTab_Comp)
    buildType(CheckParametersTab_Dep)
})
