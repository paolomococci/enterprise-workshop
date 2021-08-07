# training web application

Example of optimization and planning developed thanks to OptaPlanner, a constraint solver that uses artificial intelligence (AI).

## I proceed with the scaffolding thanks to maven, version 3.8.1:
```
mvn io.quarkus:quarkus-maven-plugin:2.1.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=training -Dextensions="resteasy,resteasy-jackson,optaplanner-quarkus,optaplanner-quarkus-jackson,quarkus-hibernate-validator,quarkus-jdbc-mariadb,quarkus-hibernate-orm-panache" -DnoExamples
```
