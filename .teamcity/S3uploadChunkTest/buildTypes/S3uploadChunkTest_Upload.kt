package S3uploadChunkTest.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object S3uploadChunkTest_Upload : BuildType({
    name = "upload"

    artifactRules = "a"

    steps {
        script {
            scriptContent = "truncate -s 50G a"
        }
    }
})
