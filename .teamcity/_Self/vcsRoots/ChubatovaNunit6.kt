package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object ChubatovaNunit6 : GitVcsRoot({
    name = "chubatova_nunit6"
    url = "https://github.com/ChubatovaTiger/nunit_core6"
    branch = "refs/heads/manytests"
})
