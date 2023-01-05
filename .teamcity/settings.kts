import buildConfig.HelloWorld
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.s3Storage
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.activeStorage

version = "2021.2"

project {
    description = "Issue from JetBrains"

    val awsRegion = DslContext.getParameter("AWS_REGION",)
    val s3Bucket = DslContext.getParameter("S3_BUCKET",)
    val awsAccessKeyId = DslContext.getParameter("AWS_ACCESS_KEY_ID")
    val awsAccessKey = DslContext.getParameter("AWS_ACCESS_KEY")

    params {
        param("teamcity.ui.settings.readOnly", "true")
//        password("env.AWS_ACCESS_KEY_ID", "credentialsJSON:aws-access-key-id", display = ParameterDisplay.HIDDEN)
//        password("env.AWS_ACCESS_KEY", "credentialsJSON:aws-access-key", display = ParameterDisplay.HIDDEN)
    }

    buildType(HelloWorld())

    features {
        s3Storage {
            id = "PROJECT_EXT_2"
            bucketName = s3Bucket
            awsEnvironment = default {
                awsRegionName = awsRegion
            }
            accessKeyID = awsAccessKeyId
            accessKey = awsAccessKey
        }
        activeStorage {
            id = "PROJECT_EXT_3"
            activeStorageID = "PROJECT_EXT_2"
        }
    }
}