package KimVMavenSimpleProjectDockerArts

import KimVMavenSimpleProjectDockerArts.buildTypes.*
import KimVMavenSimpleProjectDockerArts.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("KimVMavenSimpleProjectDockerArts")
    name = "KimV_Maven_Simple_Project_docker_arts"

    vcsRoot(KimVMavenSimpleProjectDockerArts_SshGitGitJetbrainsTeamTeamcityBuildToolsIntegrationsMavenSimpleProjectGitRefsHeadsMain)

    buildType(KimVMavenSimpleProjectDockerArts_Build)

    template(KimVMavenSimpleProjectDockerArts_DefaultTemplate)
})
