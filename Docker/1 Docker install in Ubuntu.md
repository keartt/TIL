> in Ubuntu 22.04 LTS
> 우분투에 도커 설치하기

### 1. 설치

```bash
sudo apt-get update

sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

sudo apt-get update

sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose
```
- 순서대로 실행

### 2. 확인

```bash
docker -v
docker-compose -v
sudo systemctl status docker 
```
- 도커 & 도커 컴포즈 버전 확인
- 도커 가동 여부 확인