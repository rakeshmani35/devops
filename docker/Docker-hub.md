## Create docker hub account
    - https://hub.docker.com/
    
    - Create repository in account (where image will run)

## steps to run image in docker-hub
#### 1. Create image
    docker build -t <docker-image>:<version> .
#### 2. push images to docker hub
##### - login to docker-bub
    docker login

    (provide docker-hub username and password)
##### - tag image with 
    docker tag <docker-image>:<version> <docker-hub-username>/<docker-image>:<version>
##### - push image to docker-hub
    docker push <docker-hub-username>/<docker-image>:<version>

#### pull docker image from docker-hub
    docker pull <usrname>/<image_name>:<version>


