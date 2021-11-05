# training,  web application

Example of optimization and planning developed thanks to OptaPlanner, a constraint solver that uses artificial intelligence (AI).

## I proceed with the scaffolding thanks to maven, version 3.8.1:
```
mvn io.quarkus:quarkus-maven-plugin:2.4.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=training -Dextensions="resteasy,resteasy-jackson,optaplanner-quarkus,optaplanner-quarkus-jackson,quarkus-hibernate-validator,quarkus-jdbc-postgresql,quarkus-hibernate-orm-panache,quarkus-hibernate-orm-rest-data-panache,optaplanner-quarkus-benchmark" -DnoExamples
```

## then I want to see the list of available extensions:
```
./mvnw quarkus:list-extensions
```

## follows the generic command to add an extension
```
./mvnw quarkus:add-extension -Dextensions="extension_name"
```

## and to remove an extension
```
./mvnw quarkus:remove-extension -Dextensions="extension_name"
```

## run in test mode:
```
./mvnw test
```

## run in development mode:
```
./mvnw compile quarkus:dev
```
