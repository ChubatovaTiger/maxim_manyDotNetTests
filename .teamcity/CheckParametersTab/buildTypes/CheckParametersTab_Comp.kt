package CheckParametersTab.buildTypes

import jetbrains.buildServer.configs.kotlin.*

object CheckParametersTab_Comp : BuildType({
    name = "comp"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        showDependenciesChanges = true
    }

    dependencies {
        snapshot(CheckParametersTab_Dep) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})
