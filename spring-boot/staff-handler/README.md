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
< Date: Sun, 04 Jul 2021 17:45:42 GMT
Date: Sun, 04 Jul 2021 17:45:42 GMT

< 
{
  "_links" : {
    "employees" : {
      "href" : "http://127.0.0.1:9090/employees"
    },
    "tasks" : {
      "href" : "http://127.0.0.1:9090/tasks"
    },
    "jobs" : {
      "href" : "http://127.0.0.1:9090/jobs"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /employees HTTP/1.1
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
< Date: Sun, 04 Jul 2021 17:46:14 GMT
Date: Sun, 04 Jul 2021 17:46:14 GMT

< 
{
  "_embedded" : {
    "employees" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/employees"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/employees"
    },
    "search" : {
      "href" : "http://127.0.0.1:9090/employees/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/jobs
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /jobs HTTP/1.1
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
< Date: Sun, 04 Jul 2021 17:46:46 GMT
Date: Sun, 04 Jul 2021 17:46:46 GMT

< 
{
  "_embedded" : {
    "jobs" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/jobs"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/jobs"
    },
    "search" : {
      "href" : "http://127.0.0.1:9090/jobs/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/tasks
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /tasks HTTP/1.1
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
< Date: Sun, 04 Jul 2021 17:47:12 GMT
Date: Sun, 04 Jul 2021 17:47:12 GMT

< 
{
  "_embedded" : {
    "tasks" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/tasks"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/tasks"
    },
    "search" : {
      "href" : "http://127.0.0.1:9090/tasks/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
