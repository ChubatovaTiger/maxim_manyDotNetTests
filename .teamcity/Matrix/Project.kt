package Matrix

import Matrix.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("Matrix")
    name = "matrix"

    buildType(Matrix_Matrix)
    buildType(Matrix_MatrixJDK)
})
