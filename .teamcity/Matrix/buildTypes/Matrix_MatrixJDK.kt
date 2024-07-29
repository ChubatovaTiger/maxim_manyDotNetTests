package Matrix.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.matrix

object Matrix_MatrixJDK : BuildType({
    name = "matrixJDK"

    features {
        matrix {
            param("par1", listOf(
                value("1"),
                value("2")
            ))
            param("env.JAVA_HOME", listOf(
                value("%env.JDK_11%", label = "JDK 11"),
                value("%env.JDK_17_0%", label = "JDK 17")
            ))
        }
    }
})
