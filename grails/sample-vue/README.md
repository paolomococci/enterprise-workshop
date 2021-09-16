# sample-vue

## scaffolding
I started by creating a directory with the name of the project:
```
mkdir sample-vue
```

I entered the project sample-vue directory:
```
cd sample-vue
```

I started grails in interactive mode:
```
grails
```

and I ran the following command:
```
create-app sample-vue --profile=vue
```

after setting gradlew and grailsw scripts as executable, I entered the project server directory:
```
cd server
```

then I used the following commands to create the domain classes:
```
./grailsw create-domain-class sample.vue.data.Address
```

finally, I generated everything needed to make the application work:
```
./grailsw generate-all sample.vue.data.Address
```
