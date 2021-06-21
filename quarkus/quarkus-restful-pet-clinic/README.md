# quarkus-restful-pet-clinic application

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw compile quarkus:dev
```

## Tests:
```
$ curl -d '{"name": "John"}' -H "Content-Type: application/json" http://localhost:8080/rest-owner
{"id":1,"name":"John"}

$ curl localhost:8080/rest-owner/owners
[{"id":1,"name":"John"}]

$ curl localhost:8080/rest-owner/owners?page=0&size=1
[{"id":1,"name":"John"}]

$ curl localhost:8080/rest-owner/1
{"id":1,"name":"John"}

$ curl -X PUT -d '{"name": "James"}' -H "Content-Type: application/json" localhost:8080/rest-owner/1
$ curl localhost:8080/rest-owner/1
{"id":1,"name":"James"}

$ curl -X DELETE localhost:8080/rest-owner/1
$ curl localhost:8080/rest-owner/owners
[]
```
