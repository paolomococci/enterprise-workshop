# sample-react

## scaffolding:
```
mkdir sample-react
cd sample-react
grails
grails> create-app sample-react --profile=react
grails> exit
```

## create a sample domain resource:
```
cd server
grails
grails> create-domain-resource sample.react.data.Sample
```

## create the domain classes and add properties, constraints and methods to each of them:
```
grails> create-domain-class sample.react.data.Address
grails> create-domain-class sample.react.data.Carrier
grails> create-domain-class sample.react.data.Customer
grails> create-domain-class sample.react.data.Invoice
grails> create-domain-class sample.react.data.Item
grails> create-domain-class sample.react.data.Supplier
grails> exit
```

## and now everything else:
```
grails> generate-all sample.react.data.Address
grails> generate-all sample.react.data.Carrier
grails> generate-all sample.react.data.Customer
grails> generate-all sample.react.data.Invoice
grails> generate-all sample.react.data.Item
```
