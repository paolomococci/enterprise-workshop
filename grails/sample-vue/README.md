# sample-vue

## scaffolding

I started by creating a directory with the name of the project:

```shell
mkdir sample-vue
```

I entered the project sample-vue directory:

```shell
cd sample-vue
```

I started grails in interactive mode:

```shell
grails
```

and I ran the following command:

```shell
create-app sample-vue --profile=vue
```

after setting gradlew and grailsw scripts as executable, I entered the project server directory:

```shell
cd server
```

then I used the following commands to create the domain classes:

```shell
./grailsw create-domain-class sample.vue.data.Address
```

finally, I generated everything needed to make the application work:

```shell
./grailsw generate-all sample.vue.data.Address
```
