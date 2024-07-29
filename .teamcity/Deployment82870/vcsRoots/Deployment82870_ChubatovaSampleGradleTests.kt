package Deployment82870.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object Deployment82870_ChubatovaSampleGradleTests : GitVcsRoot({
    name = "ChubatovaSampleGradleTests"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
})
