package S3uploadChunkTest

import S3uploadChunkTest.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.activeStorage
import jetbrains.buildServer.configs.kotlin.projectFeatures.s3Storage

object Project : Project({
    id("S3uploadChunkTest")
    name = "s3uploadChunkTest"

    buildType(S3uploadChunkTest_Upload)

    features {
        s3Storage {
            id = "PROJECT_EXT_3059"
            storageName = "ChubatovaS3storage"
            bucketName = "chubatovatransferacceleration"
            bucketPrefix = "buildserverSandbox"
            awsEnvironment = default {
                awsRegionName = "eu-central-1"
            }
            credentials = accessKeys()
            accessKeyID = "AKIA5JH2VERVHVMPJQJI"
            accessKey = "credentialsJSON:e40428bf-4687-4335-9adb-482928bedc24"
        }
        activeStorage {
            id = "PROJECT_EXT_3060"
            activeStorageID = "PROJECT_EXT_3059"
        }
    }
})
