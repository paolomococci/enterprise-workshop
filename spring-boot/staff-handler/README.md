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
$ curl -v -i -H "Content-Type:application/json" -d "{\"name\":\"Paul\",\"surname\":\"Bender\"}" http://127.0.0.1:9090/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> POST /employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 34
> 
* upload completely sent off: 34 out of 34 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:9090/employees/1
Location: http://127.0.0.1:9090/employees/1
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 18:00:14 GMT
Date: Sun, 04 Jul 2021 18:00:14 GMT

< 
{
  "name" : "Paul",
  "surname" : "Bender",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/employees/1"
    },
    "employeeEntity" : {
      "href" : "http://127.0.0.1:9090/employees/1"
    },
    "task" : {
      "href" : "http://127.0.0.1:9090/employees/1/task"
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
< Date: Sun, 04 Jul 2021 17:55:06 GMT
Date: Sun, 04 Jul 2021 17:55:06 GMT

< 
{
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/employees"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
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
< Date: Sun, 04 Jul 2021 17:55:55 GMT
Date: Sun, 04 Jul 2021 17:55:55 GMT

< 
{
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/jobs"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
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
< Date: Sun, 04 Jul 2021 17:56:17 GMT
Date: Sun, 04 Jul 2021 17:56:17 GMT

< 
{
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/tasks"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## I added a new item to the employee table thanks to the standard API
```

$ curl -v -i -H "Content-Type:application/json" -d "{\"name\":\"Paul\",\"surname\":\"Bender\"}" http://127.0.0.1:9090/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> POST /employees HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 34
> 
* upload completely sent off: 34 out of 34 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:9090/employees/1
Location: http://127.0.0.1:9090/employees/1
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 04 Jul 2021 18:00:14 GMT
Date: Sun, 04 Jul 2021 18:00:14 GMT

< 
{
  "name" : "Paul",
  "surname" : "Bender",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/employees/1"
    },
    "employeeEntity" : {
      "href" : "http://127.0.0.1:9090/employees/1"
    },
    "task" : {
      "href" : "http://127.0.0.1:9090/employees/1/task"
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
< Date: Sun, 04 Jul 2021 18:10:36 GMT
Date: Sun, 04 Jul 2021 18:10:36 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "name" : "Paul",
      "surname" : "Bender",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/employees/1"
        },
        "employeeEntity" : {
          "href" : "http://127.0.0.1:9090/employees/1"
        },
        "task" : {
          "href" : "http://127.0.0.1:9090/employees/1/task"
        }
      }
    } ]
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
```

## now to get the complete list I use the custom API
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
< Date: Sun, 04 Jul 2021 18:11:23 GMT
Date: Sun, 04 Jul 2021 18:11:23 GMT

< 
{
  "_embedded" : {
    "employees" : [ {
      "name" : "Paul",
      "surname" : "Bender",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/employees/1"
        },
        "employees" : {
          "href" : "http://127.0.0.1:9090/api/employees"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/employees"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
