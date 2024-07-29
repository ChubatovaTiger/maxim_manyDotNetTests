package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven

object Buildkit : BuildType({
    templates(DefaultTemplateChubatova)
    name = "buildkit"

    steps {
        maven {
            name = "Run tests"
            id = "RUNNER_3"
        }
    }
})
