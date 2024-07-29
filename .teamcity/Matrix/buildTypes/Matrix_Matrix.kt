package Matrix.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.matrix

object Matrix_Matrix : BuildType({
    name = "matrix"

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "echo python"
            dockerImage = "python"
        }
    }

    features {
        matrix {
            os = listOf(
                value("Linux"),
                value("Windows"),
                value("macOs")
            )
            param("java", listOf(
                value("11"),
                value("17")
            ))
        }
    }
})
