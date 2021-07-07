# cat-families, example of use standard APIs
web application to manage the relationships between cats, their breeders and the cat shows they participate in

## relate entities of type OneToMany and ManyToOne

### having available the two entities mother and son
```
$ curl -v -i -H "Content-Type:application/json" -d "{\"code\":\"0044556677\",\"name\":\"Mommycat\",\"level\":\"AWESOME\",\"birthday\":\"2018-04-18\"}" http://127.0.0.1:9090/mothers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> POST /mothers HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 81
> 
* upload completely sent off: 81 out of 81 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:9090/mothers/2
Location: http://127.0.0.1:9090/mothers/2
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 07 Jul 2021 13:20:10 GMT
Date: Wed, 07 Jul 2021 13:20:10 GMT

< 
{
  "code" : "0044556677",
  "name" : "Mommycat",
  "level" : "AWESOME",
  "birthday" : "2018-04-18",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/mothers/2"
    },
    "motherEntity" : {
      "href" : "http://127.0.0.1:9090/mothers/2"
    },
    "sons" : {
      "href" : "http://127.0.0.1:9090/mothers/2/sons"
    },
    "breederMotherCat" : {
      "href" : "http://127.0.0.1:9090/mothers/2/breederMotherCat"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i -H "Content-Type:application/json" -d "{\"code\":\"0099887744\",\"name\":\"Babycat\",\"level\":\"GOOD\",\"birthday\":\"2020-06-07\"}" http://127.0.0.1:9090/sons
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> POST /sons HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 77
> 
* upload completely sent off: 77 out of 77 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:9090/sons/3
Location: http://127.0.0.1:9090/sons/3
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 07 Jul 2021 13:23:25 GMT
Date: Wed, 07 Jul 2021 13:23:25 GMT

< 
{
  "code" : "0099887744",
  "name" : "Babycat",
  "level" : "GOOD",
  "birthday" : "2020-06-07",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/sons/3"
    },
    "sonEntity" : {
      "href" : "http://127.0.0.1:9090/sons/3"
    },
    "mother" : {
      "href" : "http://127.0.0.1:9090/sons/3/mother"
    },
    "breederCat" : {
      "href" : "http://127.0.0.1:9090/sons/3/breederCat"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### to establish a relationship the OneToMany URI must be sent to the related ManyToOne sub-URI, taking care to use "Content-Type:text/uri-list"
```
$ curl -v -i -X PUT -H "Content-Type:text/uri-list" -d "http://127.0.0.1:9090/mothers/2" http://127.0.0.1:9090/sons/3/mother
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> PUT /sons/3/mother HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:text/uri-list
> Content-Length: 31
> 
* upload completely sent off: 31 out of 31 bytes
< HTTP/1.1 204 
HTTP/1.1 204 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Date: Wed, 07 Jul 2021 13:56:43 GMT
Date: Wed, 07 Jul 2021 13:56:43 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
$ curl -v -i -X GET http://127.0.0.1:9090/mothers/2/sons
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /mothers/2/sons HTTP/1.1
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
< Date: Wed, 07 Jul 2021 13:59:15 GMT
Date: Wed, 07 Jul 2021 13:59:15 GMT

< 
{
  "_embedded" : {
    "sons" : [ {
      "code" : "0099887744",
      "name" : "Babycat",
      "level" : "GOOD",
      "birthday" : "2020-06-07",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/sons/3"
        },
        "sonEntity" : {
          "href" : "http://127.0.0.1:9090/sons/3"
        },
        "mother" : {
          "href" : "http://127.0.0.1:9090/sons/3/mother"
        },
        "breederCat" : {
          "href" : "http://127.0.0.1:9090/sons/3/breederCat"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/mothers/2/sons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i -X GET http://127.0.0.1:9090/sons/3/mother
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /sons/3/mother HTTP/1.1
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
< Content-Location: http://127.0.0.1:9090/mothers/2
Content-Location: http://127.0.0.1:9090/mothers/2
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 07 Jul 2021 14:01:24 GMT
Date: Wed, 07 Jul 2021 14:01:24 GMT

< 
{
  "code" : "0044556677",
  "name" : "Mommycat",
  "level" : "AWESOME",
  "birthday" : "2018-04-18",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/mothers/2"
    },
    "motherEntity" : {
      "href" : "http://127.0.0.1:9090/mothers/2"
    },
    "sons" : {
      "href" : "http://127.0.0.1:9090/mothers/2/sons"
    },
    "breederMotherCat" : {
      "href" : "http://127.0.0.1:9090/mothers/2/breederMotherCat"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### finally, to remove a relationship
```
$ curl -i -X DELETE http://127.0.0.1:9090/sons/3/mother
HTTP/1.1 204 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Date: Wed, 07 Jul 2021 14:33:56 GMT
$ curl -v -i -X GET http://127.0.0.1:9090/mothers/2/sons
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /mothers/2/sons HTTP/1.1
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
< Date: Wed, 07 Jul 2021 14:34:30 GMT
Date: Wed, 07 Jul 2021 14:34:30 GMT

< 
{
  "_embedded" : {
    "sons" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/mothers/2/sons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i -X GET http://127.0.0.1:9090/sons/3/mother
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /sons/3/mother HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 404 
HTTP/1.1 404 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Length: 0
Content-Length: 0
< Date: Wed, 07 Jul 2021 14:35:08 GMT
Date: Wed, 07 Jul 2021 14:35:08 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
```

## relate entities of type ManyToMany

### having available the two entities breeder and exposure, previously registered in the system
```
$ curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://127.0.0.1:9090/exposures/4" http://127.0.0.1:9090/breeders/1/exposures
HTTP/1.1 204 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Date: Wed, 07 Jul 2021 14:44:51 GMT
$ curl -v -i -X GET http://127.0.0.1:9090/breeders/1/exposures
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /breeders/1/exposures HTTP/1.1
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
< Date: Wed, 07 Jul 2021 14:46:48 GMT
Date: Wed, 07 Jul 2021 14:46:48 GMT

< 
{
  "_embedded" : {
    "exposures" : [ {
      "code" : "1188553377",
      "title" : "cats on the beach",
      "occurrence" : "2021-08-12",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/exposures/4"
        },
        "exposureEntity" : {
          "href" : "http://127.0.0.1:9090/exposures/4"
        },
        "breeders" : {
          "href" : "http://127.0.0.1:9090/exposures/4/breeders"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/breeders/1/exposures"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i -X GET http://127.0.0.1:9090/exposures/4/breeders
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /exposures/4/breeders HTTP/1.1
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
< Date: Wed, 07 Jul 2021 14:50:42 GMT
Date: Wed, 07 Jul 2021 14:50:42 GMT

< 
{
  "_embedded" : {
    "breeders" : [ {
      "code" : "0011223344",
      "name" : "John Doe",
      "birthday" : "1999-03-02",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/breeders/1"
        },
        "breederEntity" : {
          "href" : "http://127.0.0.1:9090/breeders/1"
        },
        "exposures" : {
          "href" : "http://127.0.0.1:9090/breeders/1/exposures"
        },
        "motherCats" : {
          "href" : "http://127.0.0.1:9090/breeders/1/motherCats"
        },
        "cats" : {
          "href" : "http://127.0.0.1:9090/breeders/1/cats"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/exposures/4/breeders"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### now, to remove the relationship it will be necessary to indicate at the end of the URI the identifier of the related entity
```
$ curl -i -X DELETE http://127.0.0.1:9090/breeders/1/exposures/4
HTTP/1.1 204 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Date: Wed, 07 Jul 2021 14:55:03 GMT
$ curl -v -i -X GET http://127.0.0.1:9090/breeders/1/exposures
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /breeders/1/exposures HTTP/1.1
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
< Date: Wed, 07 Jul 2021 14:56:10 GMT
Date: Wed, 07 Jul 2021 14:56:10 GMT

< 
{
  "_embedded" : {
    "exposures" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/breeders/1/exposures"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
