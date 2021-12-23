# basic-started

A simple example to start developing with Quarkus.

## I proceed with the scaffolding thanks to maven, version 3.8.1:
```
mvn io.quarkus:quarkus-maven-plugin:2.6.0.Final:create -DprojectGroupId=local.example -DprojectArtifactId=basic-started -DclassName="local.example.basic.ApplicationResource" -Dpath="/basic"
```

## I add extensions to access PostgreSQL
```
./mvnw quarkus:add-extension -Dextensions="quarkus-hibernate-orm-panache,quarkus-jdbc-postgresql,quarkus-resteasy-jackson"
```

## example of use:
```
$ curl -v -i -H "Content-Type:application/json" -d "{\"code\":\"21002347\",\"name\":\"someone\",\"description\":\"some description\"}" http://127.0.0.1:8080/things
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /things HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 69
> 
* upload completely sent off: 69 out of 69 bytes
< HTTP/1.1 201 Created
HTTP/1.1 201 Created
< Content-Length: 76
Content-Length: 76
< Content-Type: application/json
Content-Type: application/json

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":1,"code":"21002347","name":"someone","description":"some description"}

$ curl -v -i http://127.0.0.1:8080/things
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /things HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Content-Length: 78
Content-Length: 78
< Content-Type: application/json
Content-Type: application/json

< 
* Connection #0 to host 127.0.0.1 left intact
[{"id":1,"code":"21002347","name":"someone","description":"some description"}]

$ curl -v -i http://127.0.0.1:8080/things/1
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /things/1 HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Content-Length: 76
Content-Length: 76
< Content-Type: application/json
Content-Type: application/json

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":1,"code":"21002347","name":"someone","description":"some description"}

$ curl -v -i -X DELETE http://127.0.0.1:8080/things/1
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> DELETE /things/1 HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 204 No Content
HTTP/1.1 204 No Content

< 
* Connection #0 to host 127.0.0.1 left intact
```

## when there are no entities registered in the system you will get
```
$ curl -v -i http://127.0.0.1:8080/things
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /things HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 204 No Content
HTTP/1.1 204 No Content

< 
* Connection #0 to host 127.0.0.1 left intact

curl -v -i http://127.0.0.1:8080/somes
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /somes HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 204 No Content
HTTP/1.1 204 No Content

< 
* Connection #0 to host 127.0.0.1 left intact
```
