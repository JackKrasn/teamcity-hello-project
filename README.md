# teamcity-hello-project

This is a test project that uses the infrastructure created in [project](https://github.com/JackKrasn/aws-teamcity-infra).

## Create Test Project

Push "Create Project"

![Create project](docs/images/create_project.png)

Select "From a repository URL" and set "Repository URL" https://github.com/JackKrasn/teamcity-hello-project.git

![Repository url](docs/images/repository_url.png)

After that Click "Proceed"

![Repository url](docs/images/from_url.png)

Don't change anything.

![Repository url](docs/images/from_url.png)

Click "Proceed"

![Repository url](docs/images/context_parameters.png)

Set the following context parameters:

* S3_BUCKET - the S3 bucket name for artifact storage
* AWS_REGION - the aws region
* AWS_ACCESS_KEY_ID - the aws key id for access s3 storage
* AWS_ACCESS_KEY - the aws key for access s3 storage

After setting context parameter click "Proceed".

That’s it! We should now be able to see the "Teamcity Hello Project" and a build configuration "Hello World".

![Run](docs/images/run.png)

Click "Run Build"

After successfully building you be able to see Artifact is located in the s3 storage.

![Artifact](docs/images/artifact.png)



