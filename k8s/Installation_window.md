## install kubectl reference
    kubectl: https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/
    minikube: https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download

## Installation Steps
### 1. kubectl setup in windows:
#### 1.1 Open CMD or PowerShell on your system and execute below curl
    curl.exe -LO "https://dl.k8s.io/release/v1.31.0/bin/windows/amd64/kubectl.exe"
   <img width="702" alt="image" src="https://github.com/user-attachments/assets/17982e05-0c7c-4def-a5fe-3e41a8ea93ff">
 
#### 1.2 Download the kubectl checksum file:   
    curl.exe -LO "https://dl.k8s.io/v1.31.0/bin/windows/amd64/kubectl.exe.sha256"
  <img width="692" alt="image" src="https://github.com/user-attachments/assets/48bbd93f-19e3-4d96-958b-92cd09165010">
  
#### 1.3 Validate the kubectl binary against the checksum file:
    $(Get-FileHash -Algorithm SHA256 .\kubectl.exe).Hash -eq $(Get-Content .\kubectl.exe.sha256)
  <img width="793" alt="image" src="https://github.com/user-attachments/assets/eac1562c-bf6d-4713-aaea-07e48d3e2ad4">

####                OR
        certutil -hashfile kubectl.exe SHA256
<img width="406" alt="image" src="https://github.com/user-attachments/assets/ff7c3532-b9a9-44f3-8324-d58f40ed9924">
        

#### 1.4 Test to ensure the version of kubectl is the same as downloaded:
    kubectl version --client
  <img width="337" alt="image" src="https://github.com/user-attachments/assets/5e182d88-23b7-452d-99ea-d065867cacac">
  
 ####           OR
    kubectl version --client --output=yaml     
  <img width="499" alt="image" src="https://github.com/user-attachments/assets/dd1243fe-f8b4-43dc-b8f1-2967e00128b8">

#### 1.5 Verify that kubectl.exe has been successfully downloaded by running:
    dir kubectl.exe
<img width="401" alt="image" src="https://github.com/user-attachments/assets/aa4d7db9-0c11-4a2d-ae5a-4001380f1421">

####             OR
    where kubectl
<img width="426" alt="image" src="https://github.com/user-attachments/assets/284ef27b-3db0-4a14-bcf9-29e7e077971b">

  
## 2. minikube setup in windows
#### 2.1 Use 'winget' tool
    winget install minikube
         OR
     winget install Kubernetes.Minikube
<img width="810" alt="image" src="https://github.com/user-attachments/assets/c61d1313-7b6f-4347-9b8c-ad14e969abcd">

#### 2.2 Check minikube version in power shell
    minikube version
<img width="947" alt="image" src="https://github.com/user-attachments/assets/599e8a5e-cee8-4c19-a746-6780870271d1">

#### 2.3 start minikube with docker driver
    minikube start --driver=docker
   <img width="950" alt="image" src="https://github.com/user-attachments/assets/9e048d49-81ec-4de6-ab1c-b48fd20be07c">

#### In case of warning "Unable to resolve the current Docker CLI context “default”: context “default”: context not found: on Windows". Run below command in Power Shell
    docker context use default
<img width="363" alt="image" src="https://github.com/user-attachments/assets/e43ba9c3-9c54-4dea-a115-2a85dee6fd8e">

#### 2.4 check minikube status
     minikube status
   <img width="388" alt="image" src="https://github.com/user-attachments/assets/6a28804c-7184-4731-a3c2-d94c961a6c2d">

#### Control Plane: is master node

#### 2.5 minikube stop 
    minikube stop
  
## check kubectl cluster status
    kubectl cluster-info
  <img width="749" alt="image" src="https://github.com/user-attachments/assets/34d2aff0-94a4-4758-8a37-1e86e57e87f4">

    kubectl get node OR kubectl get nodes
  <img width="509" alt="image" src="https://github.com/user-attachments/assets/103940bd-bc30-4725-b778-e846a91de7af">

  



