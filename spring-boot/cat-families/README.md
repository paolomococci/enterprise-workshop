# cat-families
web application to manage the relationships between cats, their breeders and the cat shows they participate in

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
< Date: Tue, 06 Jul 2021 18:46:02 GMT
Date: Tue, 06 Jul 2021 18:46:02 GMT

< 
{
  "_links" : {
    "mothers" : {
      "href" : "http://127.0.0.1:9090/mothers"
    },
    "breeders" : {
      "href" : "http://127.0.0.1:9090/breeders"
    },
    "sons" : {
      "href" : "http://127.0.0.1:9090/sons"
    },
    "exposures" : {
      "href" : "http://127.0.0.1:9090/exposures"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/mothers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /mothers HTTP/1.1
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
< Date: Tue, 06 Jul 2021 18:47:19 GMT
Date: Tue, 06 Jul 2021 18:47:19 GMT

< 
{
  "_embedded" : {
    "mothers" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/mothers"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/mothers"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/breeders
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /breeders HTTP/1.1
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
< Date: Tue, 06 Jul 2021 18:48:36 GMT
Date: Tue, 06 Jul 2021 18:48:36 GMT

< 
{
  "_embedded" : {
    "breeders" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/breeders"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/breeders"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:9090/sons
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /sons HTTP/1.1
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
< Date: Tue, 06 Jul 2021 18:49:52 GMT
Date: Tue, 06 Jul 2021 18:49:52 GMT

< 
{
  "_embedded" : {
    "sons" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/sons"
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile/sons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
