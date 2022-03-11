# dmn-travel

## I will proceed to the scaffold of the project composed of some DMN, (Decision Model and Notation), models

```shell
mvn io.quarkus:quarkus-maven-plugin:2.7.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=dmn-travel -Dextensions="dmn" -DnoExamples
```

## example of use:

```shell
$ curl -X POST 'http://127.0.0.1:8080/travel' -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"age":18,"autonomy":false}'
{"autonomy":false,"score":110,"age":18}

$ curl -X POST 'http://127.0.0.1:8080/travel' -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"age":23,"autonomy":true}'
{"autonomy":true,"score":120,"age":23}
```
