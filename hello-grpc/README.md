# hello-grpc

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=hello-grpc -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="quarkus-resteasy-reactive"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```
