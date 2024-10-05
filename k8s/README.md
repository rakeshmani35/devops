## Kubernetes
##### Kubernetes is open-source container-orchestration engine or container management tool. It automate deploying, scalling and managing containerized application.

##### It schedules, run and manages isolated containers which is running on virtual/physical/cloud machine.

## 1. Kubernetes key components
<img width="523" alt="image" src="https://github.com/user-attachments/assets/f02fd7a6-83f8-4a9f-8529-ff94993262dd">


#### A kubernetes cluster has multiple 'nodes'(worker nodes). A single node has multiple 'pods'. A single pod has multiple docker containers.

## 1.1. POD. NODE, CLUSTER:
#### App-1 and App-2 running in conatiner-1 and container-2. To communicate between them we have to keep both container in same POD and POD will be in the NODE and NODE will part of cluster.
<img width="503" alt="image" src="https://github.com/user-attachments/assets/eb2e727c-28e4-4c14-9d42-7dd721c3ae76">

## 1.2. REPLICA-SET:
#### For example, we have 'db-pod' where db-container is running database instance and 'backend-pod'. 'backend-pod' cummincate with 'db-pod' to get data & do some operation. Due to some technical falut 'db-pod' is crashed and not available for 'backend-pod'. To overcome this issue, we need some more clone of 'db-pod', kubernetes offer to create replica of 'db-pod' and created new replica 'db-pod-1' and ''bd-pod-2. All pod assigned to different IP.
If any 'pod' down, kubertetes automatically assign these pod.
This is role of 'REPLICA-SET'.
<img width="617" alt="image" src="https://github.com/user-attachments/assets/e0effb3a-598d-4a7e-b8e0-f23641f1b038">

## 1.3. SERVICE:
#### Example: We have 2 POD, 'frontend-pod' and 'backend-pod' and 'backend-pod' running mulpile containers with replica of all conatiners. Frontend application calling the backend api: "http://IP1:PORT1/getorders" pointing to 'container-1'. Suppose 'container-1' crashed then 'REPLICA-SET' will assigned replica pod of 'conater-2', which is running on IP2 and PORT2. Then developer has to change in Frontend application endpoint and has to do deployment again. 
To avoid this issue, kubernetes given component is called 'SERVICE'.
SERVICE has feature like DNS, Load balancing.
<img width="473" alt="image" src="https://github.com/user-attachments/assets/bb4f0409-014f-46e0-82f4-9cf998686aec">

## 1.4. DEPLOYMENT:
#### Example: We have a NODE, and in NODE has 2 PODs (POD-1 and POD-2). POD-2 has 3 replica. How these POD, replica set understand by kubernetes by taking help of 'DEPLOYMENT' object. Kubernetes undestand only 'DEPLOYMENT' object. We can defiend 'DEPLOYMENT' component in either JSON or YML.
<img width="355" alt="image" src="https://github.com/user-attachments/assets/fa0c5934-50bb-4537-bd80-cec58a5d9bfe">

## 1.5. SECRETS & CONFIG-MAP
#### Both are used to store sensetive information like port number, username/password. Difference is that whatever store in SECRETS, it will be store in encrypted format. And CONFIG-MAP store in plain-text format.
For example: We have database URL, Driver name, username, password, amoung these passwors is more sensetive, so keep password in SECRETS and others in CONFIG-MAP.

## 1.6. ETCD:
#### This is key-value storage, which store status of cluster, nodes and pods. Kubernetes sences information and spin-up those components.

## 2. Kubernetes architecture
<img width="609" alt="image" src="https://github.com/user-attachments/assets/f751ac33-800a-4b32-afd4-4622ae9f3cd7">

## 2.1.MASTER-NODE
#### Example: We have manager, team lead and worker(joiner software engineer) in project. A new requirement came to TL, TL approach to manager. Manager ask to TL check the team capacity. TL check in jira-board/sprint-planning and confirm to manager that we have enough capacity to requirement. Manager instruct to TL to start work on requirement. TL pass the information to worker to do action.
<img width="233" alt="image" src="https://github.com/user-attachments/assets/c03393a0-21dd-4d99-857b-10123f29671f">

Similarly. In kubernetes also has Controller-Manager(manager), API-Server(TL), ETCD(storage, jira), Scheduler(worker) in master-node. When 'DEPLOYMENT' object requesting to add new 'POD' or 'Container'. Master-Node manage to add. First request of 'Master-Node' come to 'API-Server'. 'API-Server' check the fesibility to add new POD/Container by checking in 'ETCD' with help of 'Controller-Manager' confirmation. 'API-Server' ask to 'Scheduler' to do action to add POD/Container. 

<img width="512" alt="image" src="https://github.com/user-attachments/assets/092f4c1b-e3a0-4a30-9eb5-89ca11d5ce72">


## 2.2. Master-Node & Worker-Node
#### 'Worker-Node' has 2 components, 'kube proxy' and 'kubelet'. 'kubelet' is act as a manager for 'Worker-Node'. 'kubelet' share all information of POD/container to 'ETCD' and 'API-Server'. Networking stuff managing by 'kube proxy', like assign IP address to PODs.
<img width="508" alt="image" src="https://github.com/user-attachments/assets/abf4fa05-8bca-447f-b4fa-50fff9e54f7c">

<img width="551" alt="image" src="https://github.com/user-attachments/assets/dd17e27e-dba7-4bc7-8832-bf414ad66132">







