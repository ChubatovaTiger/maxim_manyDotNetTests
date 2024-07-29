package KimVMavenSimpleProjectDockerArts.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.Swabra
import jetbrains.buildServer.configs.kotlin.buildFeatures.investigationsAutoAssigner
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildFeatures.swabra

object KimVMavenSimpleProjectDockerArts_DefaultTemplate : Template({
    name = "Default Template"

    params {
        param("dotnet.interop.tests", "[TeamCity] DotNet Interop tests")
        param("hsql.only.tests", "[TeamCity] HSQL specific tests")
        param("main.tests.group", """
            [TeamCity] Common tests
            [TeamCity] Server Common Api Tests
            [TeamCity] DB Upgrade tests
            [TeamCity] Server tests
            [TeamCity] Agent tests
            [TeamCity] Launcher tests
            [TeamCity] Patches tests
            [TeamCity] Search tests
            [TeamCity] Search tests junit
            [TeamCity] Web tests
            [TeamCity] Coverage Server Common Tests
            [TeamCity] Integration tests
            [TeamCity] Plugin support tests
            [TeamCity] Cloud tests
            [TeamCity] Win32 notifier tests
            [TeamCity] IDE notifier tests
            [TeamCity] IDE common tests
            [TeamCity] IDEA settings tests
            [TeamCity] IDEA Project runner server side tests
            [TeamCity] IDEA Tool server side tests
            [TeamCity] Feed plugin tests
            [TeamCity] LDAP login tests
            [TeamCity] Issue trackers tests
            [TeamCity] JavaDowser tests
            [TeamCity] Usage statistics tests
            [TeamCity] Process terminator tests
            [TeamCity] NTLM Tests
            [TeamCity] priority-queue tests
            [TeamCity] Inspections server-side tests
            [TeamCity] ServerStartup tests
            [TeamCity] WebStartup tests
            [TeamCity] Artifacts size statistics tests
            [TeamCity] Agent Configurator Obsolete Tests
            [TeamCity] SSH manager tests
            [TeamCity] Benchmark tests
            [TeamCity] Server diagnostics tests
            [TeamCity] StackTraces tests
            [TeamCity] FileContentReplacer tests
            [TeamCity] NuGet Utils tests
            [TeamCity] jvm-update tests
            [TeamCity] Tools Management tests
            [TeamCity] Flaky Test Detector Tests
            [TeamCity] federation tests
            [TeamCity] Reset Password Tests
            [TeamCity] OAuth integration web tests
            [TeamCity] Change viewers plugin tests
            [TeamCity] ServerUpdate tests
            [TeamCity] Coverage Java Agent
            [TeamCity] CompareBuilds Tests
            [TeamCity] ReactUI Plugin Tests
            [TeamCity] VCS Hostings tests
            [TeamCity] XML Tests Reporting tests
        """.trimIndent())
        param("cvs_svn_perforce_starteam.tests", """
            [TeamCity] CVS support tests
            [TeamCity] SVN support tests
            [TeamCity] Perforce support tests
            [TeamCity] Starteam support tests
        """.trimIndent())
        text("nugetplugin.branch", "refs/heads/master", display = ParameterDisplay.HIDDEN, allowEmpty = false)
        param("runtime_jdk", "%env.JDK_1_8%")
        param("tfs.tests", "[TeamCity] TFS support tests")
        param("security.tests", "[TeamCity] Security tests")
        param("agent.upgrade.tests", "[TeamCity] Agent upgrade tests")
        param("performance.tests", "[TeamCity] Performance Tests")
        param("windows.only.tests", "")
        text("nuget.branchspec", """
            -:refs/heads/Jaipur-2018.2.x
            -:refs/heads/Jaipur-2018.2.x*
            -:refs/heads/Kanpur-2019.1.x
            -:refs/heads/Kanpur-2019.1.x*
            -:refs/heads/Kanpur-2019.2.x
            -:refs/heads/Kanpur-2019.2.x*
            -:refs/heads/Lakhnau-2020.1.x
            -:refs/heads/Lakhnau-2020.1.x*
            -:refs/heads/Lakhnau-2020.2.x
            -:refs/heads/Lakhnau-2020.2.x*
            -:refs/heads/release/2021.1.*
            -:refs/heads/development/*
            -:refs/heads/cloud
            -:refs/heads/cloud*
            -:refs/heads/remote-run/*
            +:refs/heads/*
            +:(refs/merge/*)
        """.trimIndent(), display = ParameterDisplay.HIDDEN, allowEmpty = false)
        param("project_jdk", "%env.JDK_1_8%")
        param("agent_jdk", "%env.JDK_1_8%")
        param("mysql.only.tests", "[TeamCity] MySQL specific tests")
        param("rake.runner.tests", "[TeamCity] RakeRunner test")
        param("teamcity.artifacts.transport", "TorrentTransport")
        param("teamcity.investigationsAutoAssigner.delayAssignments", "true")
        param("dotnet.runners.tests", """
            [TeamCity] DotNet Slow Tests
            [TeamCity] DotNet TestRunner Tests
            [TeamCity] DotNet MSTest Tests
            [TeamCity] DotNet Coverage Tests
            [TeamCity] AssemblyInfoPatcher tests
            [TeamCity] DotNet MSBuild Server Tests
            [TeamCity] DotNet VSTest Tests
        """.trimIndent())
    }

    features {
        swabra {
            id = "swabra"
            lockingProcesses = Swabra.LockingProcessPolicy.KILL
            paths = """
                -:node_modules
                -:*/node_modules
            """.trimIndent()
        }
        perfmon {
            id = "perfmon"
        }
        investigationsAutoAssigner {
            id = "InvestigationsAutoAssigner"
            excludeUsers = """
                evgeniy.koshkin
                andrey.shcheglov
                dmitry.neverov
                igor.shevchenko
                nikita.skvortsov
            """.trimIndent()
            assignOnSecondFailure = true
        }
    }
})
