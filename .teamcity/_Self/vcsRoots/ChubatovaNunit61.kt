package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object ChubatovaNunit61 : GitVcsRoot({
    name = "chubatova_nunit6 (1)"
    url = "https://github.com/ChubatovaTiger/nunit_core6"
    branch = "refs/heads/10000classes10tests50ms"
})
