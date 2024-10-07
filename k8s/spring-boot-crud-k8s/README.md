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
#### 2.1 create kubernetes docker image using minikube
    minikube docker-env
<img width="863" alt="image" src="https://github.com/user-attachments/assets/48db7fa1-2a9c-4e18-bc84-9e05d926126d">

#### 2.2  create docker image of application
    docker build -t springapp:1.0 .
<img width="955" alt="image" src="https://github.com/user-attachments/assets/38ddc007-386f-44c8-a049-ee5318c4962a">

#### 2.3 check docker images
    docker images    
<img width="622" alt="image" src="https://github.com/user-attachments/assets/466a03a8-92c8-4c13-b1d0-9811fe9c2abe">

#### 2.4 create namespace for application
    kubectl create namespace myappnamespace
![Uploading image.png…]()

#### 2.5 create deployment object (replica=3 means 3 pod will create and each pod run springapp image)
    kubectl create deployment userapp-deployment --image=springapp:1.0 --replicas=3 port=9191 --namespace=myappnamespace

#### 2.6 check deployment object
    kubectl get deployment -n myappnamespace

#### 2.7 check K8S pods
    kubectl get pods

