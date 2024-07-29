package Ec2tw81850

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudImage
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudProfile

object Project : Project({
    id("Ec2tw81850")
    name = "EC2_TW81850"

    params {
        param("teamcity.internal.ec2.ui.react.enabled", "true")
    }

    features {
        amazonEC2CloudImage {
            id = "PROJECT_EXT_2467"
            profileId = "amazon-217"
            agentPoolId = "-2"
            name = "Copy0 of im1chubatova"
            iamProfile = "chubatovaEc2role"
            instanceType = "t2.micro"
            securityGroups = listOf("sg-0bfa5084996abf361")
            useSpotInstances = true
            spotInstanceBidPrice = 1.0
            source = Source("ami-0b9308ec4c1afd22f")
        }
        amazonEC2CloudProfile {
            id = "amazon-217"
            name = "chubatovaEc2Profile"
            terminateAfterBuild = true
            terminateIdleMinutes = 30
            region = AmazonEC2CloudProfile.Regions.EU_WEST_LONDON
            authType = accessKey {
                keyId = "credentialsJSON:64d3a424-e4b8-4e0e-9173-5e28f75a61af"
                secretKey = "credentialsJSON:e40428bf-4687-4335-9adb-482928bedc24"
            }
            param("terminateTimeOut_checkbox", "true")
        }
    }
})
