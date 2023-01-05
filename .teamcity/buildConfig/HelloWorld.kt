package buildConfig

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

class HelloWorld() : BuildType({

    name = "Hello World bc"
    description = "Test buildConfig"
    id ("test_HelloWorld")

    artifactRules = "result.txt"

    steps {
        script {
            name = "Print str"
            scriptContent = """echo 'Hello World' > result.txt"""
        }
    }
})