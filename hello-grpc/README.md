# hello-grpc

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=hello-grpc -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="quarkus-resteasy-reactive"
```

## generate the classes

```shell
mvn compile
```

## important: add the following plugin to the pom.xml file in the "build" section to be able to index the newly generated dependencies

```text
    <plugin>
      <groupId>org.jboss.jandex</groupId>
      <artifactId>jandex-maven-plugin</artifactId>
      <version>1.2.3</version>
      <executions>
        <execution>
          <id>make-index</id>
          <goals>
            <goal>jandex</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

## I test the application using the command line

```shell
curl -i -X GET http://127.0.0.1:8080/outcome
```

getting:

```text
HTTP/1.1 200 OK
content-length: 6
Content-Type: text/plain;charset=UTF-8

Hello
```

```shell
curl -i -X GET http://127.0.0.1:8080/outcome/John
```

getting:

```text
HTTP/1.1 200 OK
content-length: 10
Content-Type: text/plain;charset=UTF-8

Hello John
```
