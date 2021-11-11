## example_lambda

- [User Guide](https://docs.micronaut.io/2.5.5/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.5/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.5/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Handler

[AWS Lambda Handler](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)


## Build project

```bash
./gradlew clean build
```

## Run tests

```bash
./gradlew clean test
```

## Feature aws-lambda documentation

- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)

## Run my-function local with SAM

Handler: co.com.example_lambda.my.function.controller.LambdaController::execute

```bash
sam local invoke myfunction --event ./events/my-function-generic.json
```
