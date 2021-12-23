# sample-web

## scaffolding:

```shell
mkdir sample-web
cd sample-web
grails
grails> create-app sample-web --profile=web
```

## create the entities and add properties, constraints and methods to each of them:

```shell
./grailsw create-domain-class sample.web.data.Address
./grailsw create-domain-class sample.web.data.Carrier
./grailsw create-domain-class sample.web.data.Customer
./grailsw create-domain-class sample.web.data.Invoice
./grailsw create-domain-class sample.web.data.Item
./grailsw create-domain-class sample.web.data.Supplier
```

## and now everything else:

```shell
./grailsw generate-all sample.web.data.Address
./grailsw generate-all sample.web.data.Carrier
./grailsw generate-all sample.web.data.Customer
./grailsw generate-all sample.web.data.Invoice
./grailsw generate-all sample.web.data.Item
./grailsw generate-all sample.web.data.Supplier
```

## finally, start:

```shell
./grailsw run-app
```

![address view](https://github.com/paolomococci/enterprise-workshop/blob/main/screenshots/screenshot_grails_sample-web_address.png)
