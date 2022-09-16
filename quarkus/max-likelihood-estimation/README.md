# max-likelihood-estimation

## Scaffolding:

```shell
mvn io.quarkus:quarkus-maven-plugin:2.12.2.Final:create -DprojectGroupId=local.example.likelihood -DprojectArtifactId=max-likelihood-estimation -DclassName="local.example.likelihood.MaxLikelihoodEstimation" -Dpath="/likelihood" -DnoExamples
```

## Development mode:

```shell
./mvnw compile quarkus:dev
```

## Test:

```shell
./mvnw test
```

## Example of use:

```shell
$ curl -w "\n" http://localhost:8080/likelihood
Max Likelihood Estimation, response example in TEXT_PLAIN
$ curl -w "\n" http://localhost:8080/likelihood/injected_string
injected value: injected_string
```
