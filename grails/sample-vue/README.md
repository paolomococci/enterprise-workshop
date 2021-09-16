# sample-vue

after setting gradlew and grailsw scripts as executable, I entered the project server directory:
```
cd sample-vue/server
```
then I used the following commands to create the domain classes:
```
./grailsw create-domain-class sample.vue.data.Address
```
finally, I generated everything needed to make the application work:
```
./grailsw generate-all sample.vue.data.Address
```
