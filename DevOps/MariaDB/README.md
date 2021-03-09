# From within the directory where the Dockerfile is, you can run the following commands:

```
sudo docker build --tag mariadb_image .
sudo docker image ls
sudo docker run -d --name example_store -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 mariadb_image
sudo docker ps --all
sudo docker stop container_id
sudo docker start container_id
```
