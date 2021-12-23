# sample-angular

## scaffolding:

```shell
mkdir sample-angular
cd sample-angular
grails
grails> create-app sample-angular --profile=angular
grails> exit
```

## Server side

### create the domain resources:

```shell
cd server
grails
grails> create-domain-resource sample.angular.data.Employee
grails> create-domain-resource sample.angular.data.Manager
grails> create-domain-resource sample.angular.data.Warehouse
```

### create the domain classes:

```shell
grails> create-domain-class sample.angular.data.Address
grails> create-domain-class sample.angular.data.Carrier
grails> create-domain-class sample.angular.data.Customer
grails> create-domain-class sample.angular.data.Invoice
grails> create-domain-class sample.angular.data.Item
grails> create-domain-class sample.angular.data.Supplier
grails> exit
```

### after adding properties, constraints and methods to each entity:

```shell
grails> generate-all sample.angular.data.Address
grails> generate-all sample.angular.data.Carrier
grails> generate-all sample.angular.data.Customer
grails> generate-all sample.angular.data.Employee
grails> generate-all sample.angular.data.Invoice
grails> generate-all sample.angular.data.Item
grails> generate-all sample.angular.data.Manager
grails> generate-all sample.angular.data.Supplier
grails> generate-all sample.angular.data.Warehouse
```

## Client side

### generate components:

```shell
cd ../client
ng help
ng generate --help
ng generate component Address
ng generate component Carrier
ng generate component Customer
ng generate component Employee
ng generate component Invoice
ng generate component Item
ng generate component Manager
ng generate component Supplier
ng generate component Warehouse
```
