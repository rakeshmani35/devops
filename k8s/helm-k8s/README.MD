                                                             Helm for Kubernetes
### 1.	Installation

https://helm.sh/docs/intro/install/

winget install Helm.Helm
 

Check version
 

2.	Create a spring boot web application with “Dockerfile.yaml”
Dockerfile.yaml
# Use the official OpenJDK 17 image from Docker Hub
FROM openjdk:17
# Set working directory inside the container
WORKDIR /app
# Copy the compiled Java application JAR file into the container
COPY ./target/spring-docker.jar /app
# Expose the port the Spring Boot application will run on
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "spring-docker.jar"]






3.	Start docker and minikube
~ docker context use default
~minikube start --driver=docker


 



4.	Create Kubernetes images

minikube docker-env
 


@FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i
 







docker images
 



5.	Run spring Application in K8S
-	Build docker image
Goto project directory

cmd: docker build -t spring-helm:1.0 .
 








In docker container image is created
 

cmd: docker images
 





6.	Create helm chart

cmd: helm create spring-helm-chart

 




in application can see helm chart created
 

cmd: tree spring-helm-chart
 


7.	install helm chart
cmd: helm install myapp-chart spring-helm-chart
 


cmd: helm list
 

cmd: kubectl get all
 



              cmd: kubectl get pods
 


