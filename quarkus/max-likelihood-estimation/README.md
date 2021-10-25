# max-likelihood-estimation

## Scaffolding:
```
mvn io.quarkus:quarkus-maven-plugin:2.3.1.Final:create -DprojectGroupId=local.example.likelihood -DprojectArtifactId=max-likelihood-estimation -DclassName="local.example.likelihood.MaxLikelihoodEstimation" -Dpath="/likelihood" -DnoExamples
```

## Development mode:
```
./mvnw compile quarkus:dev
```

## Test:
```
./mvnw test
```

## Example of use:
```
$ curl -w "\n" http://localhost:8080/likelihood
Max Likelihood Estimation, response example in TEXT_PLAIN
$ curl -w "\n" http://localhost:8080/likelihood/injected_string
injected value: injected_string
```
