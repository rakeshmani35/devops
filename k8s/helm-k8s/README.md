                                                             Helm for Kubernetes
### 1.	Helm Installation

https://helm.sh/docs/intro/install/

    winget install Helm.Helm
 <img width="472" alt="image" src="https://github.com/user-attachments/assets/34382d3b-6202-477b-a332-1585ec7ac0c7">


#### Check version
    helm version          
 <img width="471" alt="image" src="https://github.com/user-attachments/assets/79df4df6-27f6-4f0b-b313-c1942dfeca63">


### 2.	Create a spring boot web application with “Dockerfile.yaml”
Dockerfile.yaml
~~~
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
~~~





### 3.	Start minikube
    docker context use default
    minikube start --driver=docker

<img width="472" alt="image" src="https://github.com/user-attachments/assets/3ba07850-60cd-4eb7-b4a7-d2ed8a6b8508">

 



### 4.	Create Kubernetes images

    minikube docker-env
 <img width="469" alt="image" src="https://github.com/user-attachments/assets/b521d514-7329-4e78-8f29-dff54449b292">



    @FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i
 <img width="467" alt="image" src="https://github.com/user-attachments/assets/aa64ac61-9963-4603-ad2d-5191b65c69be">


#### docker images
    docker images
 <img width="472" alt="image" src="https://github.com/user-attachments/assets/42e13d21-fd8f-4817-b2d8-7fe7d18f1b41">

### check minikube status (minikube is synk with docker or not, should show "docker-env: in-use")
    minikube status
  <img width="420" alt="image" src="https://github.com/user-attachments/assets/0c0a99f8-2cd8-4206-ba54-50a7f3663212">


### 5.	Run spring Application in K8S
Build docker image
Goto project directory

    docker build -t spring-helm:1.0 .
 
<img width="468" alt="image" src="https://github.com/user-attachments/assets/56191bf9-7299-41dd-bf2d-c8e9beadd9c3">


#### In docker container image is created
    docker images
 <img width="470" alt="image" src="https://github.com/user-attachments/assets/f22be8e5-47ad-4088-ad83-a0d3d26ce6f8">






### 6.	Create helm chart

    helm create spring-helm-chart

 <img width="470" alt="image" src="https://github.com/user-attachments/assets/1c25e872-d1e2-4c56-a30d-957f52681b61">


#### in application can see helm chart created
  <img width="186" alt="image" src="https://github.com/user-attachments/assets/b6cc3512-9936-435f-9d7c-3607358b7061">

     tree spring-helm-chart
 <img width="425" alt="image" src="https://github.com/user-attachments/assets/b8c7f7a8-32fd-4022-8cb8-392940bc141c">



### 7.	install helm chart
    helm install myapp-chart spring-helm-chart
 <img width="468" alt="image" src="https://github.com/user-attachments/assets/7cd3c6dc-15c1-41ce-92a7-0fbfd50c1e40">

    helm list
 <img width="470" alt="image" src="https://github.com/user-attachments/assets/dc446856-52e6-4e69-a273-793fef27efae">


    kubectl get all
 <img width="754" alt="image" src="https://github.com/user-attachments/assets/49b53d61-3dee-4022-9167-56107caeb3b2">


     kubectl get pods
 <img width="752" alt="image" src="https://github.com/user-attachments/assets/2cccaccc-b7cd-436d-86fb-6534e4bc32a4">


### 8. Test applivation
    kubectl get svc
<img width="689" alt="image" src="https://github.com/user-attachments/assets/e7f91ff7-b876-49f7-ac8d-914ca016beb6">

#### proxy url
    minikube servie myapp-chart-spring-helm-chart
<img width="672" alt="image" src="https://github.com/user-attachments/assets/c306ef79-c607-40d1-9883-a38c77556077">

#### http://127.0.0.1:59199/customer
<img width="263" alt="image" src="https://github.com/user-attachments/assets/dabe50aa-e31a-4888-9085-81c24b127ae4">


