# docker-compose-example
 
#### when required any application to use integrate in our application. We need to perform certain steps by using docker to work around.
    1. docker pull existing images
    2. run those images
#### example: for mysql
    docker pull bitnomi/mysql:<version>
    docker run mysq:<mysql>

#### This is repeatitive steps for all required application. To avoid this, we can automate these steps by using docker-composer. We can defind steps in "docker-compoe.yml" file.    
