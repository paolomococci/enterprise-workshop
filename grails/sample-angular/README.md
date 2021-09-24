# sample-angular

## scaffolding:
```
mkdir sample-angular
cd sample-angular
grails
grails> create-app sample-angular --profile=angular
grails> exit
```

## create the domain resources:
```
cd server
grails
grails> create-domain-resource sample.angular.data.Employee
grails> create-domain-resource sample.angular.data.Manager
grails> create-domain-resource sample.angular.data.Warehouse
```
