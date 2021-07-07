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
