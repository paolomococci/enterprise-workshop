# PostgreSQL containerized

## from within the directory where the Dockerfile is, you can run the following commands:

```
sudo docker build --tag postgres_image .
sudo docker run -d --name postgres_container -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=sampledb -p 5432:5432 postgres_image
sudo docker ps --all
sudo docker stop container_id
sudo docker start container_id
```
