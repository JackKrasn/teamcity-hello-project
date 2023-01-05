package buildConfig

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.ParameterDisplay
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

class HelloWorld() : BuildType({

    name = "Hello World"
    description = "Save any string in file"
    id ("test_HelloWorld")

    artifactRules = "result.txt"

    params {
        text(
            "env.VALUE_STR", "Hello World",
            label = "Any string",
            display = ParameterDisplay.PROMPT,
            allowEmpty = false,
        )
    }

    steps {
        script {
            name = "Print string"
            scriptContent = """echo '%env.VALUE_STR%' > result.txt"""
        }
    }
})