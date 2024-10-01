## Docker Engine

#### Docker-file create in application and Docker-engine create the image by using docker-file. And Docker-engine is push the imgae in Docker-container

<img width="478" alt="image" src="https://github.com/user-attachments/assets/753326a8-4ef3-4882-a7a1-0df64f8d0bae">

## Docker windows commands
#### 1. Start Docker:    docker start
#### 2. Check Docker version:    docker --version
#### 3. List Docker images:    docker images
#### 4. List running containers:    docker ps
#### 5. List all container:    docker ps -a
#### 6. Pull an image from Docker Hub:    docker pull <image_name>
#### 7. Run a Docker container:    docker run -d -p <host_port>:<container_port> <image_name>
#### 8. Stop a running container:    docker stop <container_id>
#### 9. Remove a container:    docker rm <container_id>
#### 10. Remove an image:    docker rmi <image_id>
#### 11. Build an image from a Dockerfile:    docker build -t <image_name>:<version> .
#### 12. View logs of a container:    docker logs <container_id>
#### 13. Execute a command inside a running container:    docker exec -it <container_id> /bin/bash
#### 14. Remove all stopped containers:    docker container prune
#### 15. Remove all unused images:    docker image prune


## Steps to create, verify and run image
#### - create image:  docker build -t <image_name>:version .
#### - check image: docker images
#### - run image in container: docker run -d -p <host_port>:<container_port> <image_name>:version
#### - verify running container: docker ps
#### - check log: docker log <container_id>
#### - execute container (where image is running): docker exec -it <container_id> /bin/bash
