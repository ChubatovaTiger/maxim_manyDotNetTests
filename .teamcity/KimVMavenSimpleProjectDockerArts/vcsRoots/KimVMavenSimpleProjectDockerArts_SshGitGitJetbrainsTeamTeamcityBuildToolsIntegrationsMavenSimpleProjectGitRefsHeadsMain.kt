package KimVMavenSimpleProjectDockerArts.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object KimVMavenSimpleProjectDockerArts_SshGitGitJetbrainsTeamTeamcityBuildToolsIntegrationsMavenSimpleProjectGitRefsHeadsMain : GitVcsRoot({
    name = "ssh://git@git.jetbrains.team/teamcity-build-tools-integrations/maven-simple-project.git#refs/heads/main"
    url = "ssh://git@git.jetbrains.team/teamcity-build-tools-integrations/maven-simple-project.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = uploadedKey {
        userName = "git"
        uploadedKey = "default teamcity key"
    }
})
