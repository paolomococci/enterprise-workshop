# sample-web

## scaffolding:
```
mkdir sample-web
cd sample-web
grails
grails> create-app sample-web --profile=web
```

## make entities:
```
./grailsw create-domain-class sample.web.data.Address
./grailsw create-domain-class sample.web.data.Carrier
./grailsw create-domain-class sample.web.data.Customer
./grailsw create-domain-class sample.web.data.Invoice
./grailsw create-domain-class sample.web.data.Item
./grailsw create-domain-class sample.web.data.Supplier
```

## and now everything else:
```
./grailsw generate-all sample.web.data.Address
```
