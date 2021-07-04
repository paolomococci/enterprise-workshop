# staff-handler

## example of use standard APIs
```
$ curl -v -i http://127.0.0.1:9090
* Rebuilt URL to: http://127.0.0.1:9090/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 02:57:55 GMT
Date: Sun, 04 Jul 2021 02:57:55 GMT

< 
{
  "_links" : {
    "employees" : {
      "href" : "http://127.0.0.1:9090/employees"
    },
    "jobs" : {
      "href" : "http://127.0.0.1:9090/jobs"
    },
    "tasks" : {
      "href" : "http://127.0.0.1:9090/tasks"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## examples of use customized APIs
```
$ curl -v -i http://127.0.0.1:9090/api/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 02:59:30 GMT
Date: Sun, 04 Jul 2021 02:59:30 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"_links":{"self":{"href":"http://127.0.0.1:9090/api/employees"}}}

$ curl -v -i http://127.0.0.1:9090/api/tasks
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/tasks HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 03:00:40 GMT
Date: Sun, 04 Jul 2021 03:00:40 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"_links":{"self":{"href":"http://127.0.0.1:9090/api/tasks"}}}

$ curl -v -i http://127.0.0.1:9090/api/jobs
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/jobs HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 03:01:14 GMT
Date: Sun, 04 Jul 2021 03:01:14 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"_links":{"self":{"href":"http://127.0.0.1:9090/api/jobs"}}}
```

## I create a new item in the employee table
```
$ curl -v -i http://127.0.0.1:9090/api/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 13:51:11 GMT
Date: Sun, 04 Jul 2021 13:51:11 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"_embedded":{"employees":[{"id":1,"name":"Paul","surname":"Bender","_links":{"self":{"href":"http://127.0.0.1:9090/api/employees/1"},"employees":{"href":"http://127.0.0.1:9090/api/employees"}}}]},"_links":{"self":{"href":"http://127.0.0.1:9090/api/employees"}}}

$ curl -v -i http://127.0.0.1:9090/api/employees/1
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/employees/1 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 14:00:31 GMT
Date: Sun, 04 Jul 2021 14:00:31 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":1,"name":"Paul","surname":"Bender","_links":{"self":{"href":"http://127.0.0.1:9090/api/employees/1"},"employees":{"href":"http://127.0.0.1:9090/api/employees"}}}
```
