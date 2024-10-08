### cURL

```
curl --location 'http://127.0.0.1:53887/products/bulk' \
--header 'Content-Type: application/json' \
--data '[
    {
        "code": "P001",
        "name": "Product 1",
        "quantity": 10,
        "availableDC": "DC1,DC2"
    },
    {
        "code": "P002",
        "name": "Product 2",
        "quantity": 20,
        "availableDC": "DC1,DC3"
    },
    {
        "code": "P003",
        "name": "Product 3",
        "quantity": 15,
        "availableDC": "DC2,DC3"
    },
    {
        "code": "P004",
        "name": "Product 4",
        "quantity": 25,
        "availableDC": "DC1,DC4"
    }
]'
```

## 1. work flow in K8S container
#### 1.1 create docker file
#### 1.2 create a docker image
#### 1.3 push docker image in K8S-container
<img width="429" alt="image" src="https://github.com/user-attachments/assets/62a76202-eb4c-468a-8d1f-d7ccf176e7fa">

## 2. Run application in K8S (using command)
#### Goto project directry and open in CMD
#### 2.1 Start minikube
    docker context use default
 <img width="260" alt="image" src="https://github.com/user-attachments/assets/043bd986-4733-487e-941f-4bb700e6ce9a">

    minikube start --driver=docker
 <img width="948" alt="image" src="https://github.com/user-attachments/assets/fe3de29c-e8de-4268-bca8-d904d71b803a">
   
#### 2.2 create kubernetes docker image using minikube
    minikube docker-env
<img width="863" alt="image" src="https://github.com/user-attachments/assets/48db7fa1-2a9c-4e18-bc84-9e05d926126d">

#### DOCKER_TLS_VERIFY=1: This enables TLS verification for secure communication.
#### DOCKER_HOST=tcp://127.0.0.1:2376: This sets Docker to use Minikube's Docker daemon, which listens on the localhost at port 2376.
#### DOCKER_CERT_PATH=C:\Users\YourUsername.minikube\certs: This is the path to the Minikube certificates needed for Docker to securely communicate with Minikube’s Docker daemon.
#### MINIKUBE_ACTIVE_DOCKERD=minikube: This indicates that the active Docker environment is now Minikube.

#### 2.3 To apply these settings in CMD, you need to execute them
    @FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i
<img width="727" alt="image" src="https://github.com/user-attachments/assets/793231dc-2136-4d27-a7d2-1b036f4a9e37">

#### 2.4  create docker image of application
    docker build -t springapp:1.0 .
<img width="955" alt="image" src="https://github.com/user-attachments/assets/38ddc007-386f-44c8-a049-ee5318c4962a">

#### 2.5 check docker images
    docker images    
<img width="676" alt="image" src="https://github.com/user-attachments/assets/0ff6daaa-05ee-4a2d-a09d-c6600903a4b0">

#### 2.6 create namespace for application
    kubectl create namespace myappnamespace
<img width="614" alt="image" src="https://github.com/user-attachments/assets/629d6c72-fefc-47bf-85df-38a9d617edbd">

#### 2.7 create deployment object (replica=3 means 3 pod will create and each pod run springapp image)
    kubectl create deployment userapp-deployment --image=springapp:1.0 --replicas=3 port=9191 --namespace=myappnamespace

#### 2.8 check deployment object
    kubectl get deployment -n myappnamespace

#### 2.9 check K8S pods
    kubectl get pods

## 3. Important windows command
#### 3.1 delete a Kubernetes namespace using kubectl
    kubectl delete namespace <namespace-name>

#### 3.2 Verify namespace
    kubectl get namespaces
