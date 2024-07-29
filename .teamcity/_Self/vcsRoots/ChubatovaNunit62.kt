package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object ChubatovaNunit62 : GitVcsRoot({
    name = "chubatova_nunit6 (2)"
    url = "https://github.com/ChubatovaTiger/nunit_core6"
    branch = "refs/heads/manytestsNoIgnored"
})
