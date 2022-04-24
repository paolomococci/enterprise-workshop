# training,  web application

Example of optimization and planning developed thanks to OptaPlanner, a constraint solver that uses artificial intelligence (AI).

## I proceed with the scaffolding thanks to maven, version 3.8.1:

```shell
mvn io.quarkus:quarkus-maven-plugin:2.8.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=training -Dextensions="resteasy,resteasy-jackson,optaplanner-quarkus,optaplanner-quarkus-jackson,quarkus-hibernate-validator,quarkus-jdbc-postgresql,quarkus-hibernate-orm-panache,quarkus-hibernate-orm-rest-data-panache,optaplanner-quarkus-benchmark" -DnoExamples
```

## then I want to see the list of available extensions:

```shell
./mvnw quarkus:list-extensions
```

## follows the generic command to add an extension

```shell
./mvnw quarkus:add-extension -Dextensions="extension_name"
```

## and to remove an extension

```shell
./mvnw quarkus:remove-extension -Dextensions="extension_name"
```

## run in test mode:

```shell
./mvnw test
```

## run in development mode:

```shell
./mvnw compile quarkus:dev
```
