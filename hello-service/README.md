# hello-service

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=hello-service -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,quarkus-resteasy-reactive" -DbuildTool=gradle
```

## compile

```shell

```

## run application in development mode

```shell
./gradlew quarkusDev
```
