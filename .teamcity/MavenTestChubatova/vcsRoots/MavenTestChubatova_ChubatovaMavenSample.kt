package MavenTestChubatova.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object MavenTestChubatova_ChubatovaMavenSample : GitVcsRoot({
    name = "ChubatovaMavenSample"
    url = "https://github.com/ChubatovaTiger/mavenJunit"
    branch = "refs/heads/main"
})
