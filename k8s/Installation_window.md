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
  
#### 1.4 Test to ensure the version of kubectl is the same as downloaded:
    kubectl version --client
            OR
    kubectl version --client --output=yaml        
## 2. minikube setup in windows
#### 2.1 
