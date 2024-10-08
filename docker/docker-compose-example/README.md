# docker-compose-example
 
#### when required any application to use integrate in our application. We need to perform certain steps by using docker to work around.
    1. docker pull existing images
    2. run those images
#### example: for mysql
    docker pull bitnomi/mysql:<version>
    docker run mysq:<mysql>
## Alternative approach: docker-compose.yml
#### This is repeatitive steps for all required application. To avoid this, we can automate these steps by using docker-composer. We can defind steps in "docker-compoe.yml" file.    

## steps to dockrize with mysql
#### 1. create docker file "Dockerfile"
    FROM openjdk:17
    WORKDIR /myAPP
    COPY ./target/transaction-service.jar /myAPP
    EXPOSE 8181
    CMD ["java","-jar","transaction-service.jar"]

 #### 2. create docker-compose.yml
    version: '3.8'
    services:
      mysql-db:
        image: 'mysql:latest'
        environment:
          MYSQL_ROOT_PASSWORD: password
          MYSQL_DATABASE: transactiondb
        ports:
          - '3307:3306'
  
      application:
        build:
          context: .
          dockerfile: Dockerfile
        image: transaction-service:1.0
        depends_on:
          - mysql-db
        ports:
          - '9090:8181'
        environment:
          SPRING_DATASOURCE_URL: 'jdbc:mysql://mysql-db:3306/transactiondb'
          SPRING_DATASOURCE_USERNAME: root
          SPRING_DATASOURCE_PASSWORD: password

#### version:
    This is docker-compose.yml file format. This is OPTIONAL. if not give, latest version will be take.
#### service:
    service has name of service (application). e.g. for mysql = mysql-db, for kafka = kafka
    image: latest image
    environment: my sql databse password, database name and port(host machine port:mysql port)

#### application:
    build: Build the application by pull the 'dockerfile' with image/version
    depens-db = service name(in this case mysql-db)
    ports: container port:application port
    environment: database details following the spring proeprties file naming convesion

## Steps to Run application
#### 1. Build Application by skiping test
    mvn clean install -DskipTests
#### 2. Run docker compose file (start local docker first)
    docker-compose up -d
<img width="898" alt="image" src="https://github.com/user-attachments/assets/29b763cd-4de8-4610-81ff-52c3fe687d77">  

#### 3. Check image will be create in local docker
<img width="943" alt="image" src="https://github.com/user-attachments/assets/ea388647-85a4-4b87-908f-8351eaed546a">

#### 4. Verify database connectin with port:3307 (this is container port)
<img width="529" alt="image" src="https://github.com/user-attachments/assets/335cdbd0-a4b9-43d1-9188-0de56bcc706a">

