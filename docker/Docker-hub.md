## Create docker hub account
    - https://hub.docker.com/
    
    - Create repository in account (where image will run)

## steps to run image in docker-hub
#### 1. Create image
    docker build -t <docker-image>:<version> .
#### 2. push images to docker hub
##### - login to docker-bub
    docker login
<img width="944" alt="image" src="https://github.com/user-attachments/assets/1c271d94-ffce-4d23-bf9f-c411ae850dc0">

##### - tag image with 
    docker tag <docker-image>:<version> <docker-hub-username>/<docker-image>:<version>
##### - push image to docker-hub
    docker push <docker-hub-username>/<docker-image>:<version>

### Pull docker image from docker-hub
    docker pull <usrname>/<image_name>:<version>

  e.g docker pull bitnami/mongodb
  <img width="944" alt="image" src="https://github.com/user-attachments/assets/6966fdbe-073b-45ca-bc36-5bb2344e942a">




