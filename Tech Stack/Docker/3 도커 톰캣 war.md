
> 자바1.8 톰캣 9 도커 실행

# 톰캣 도커에서 실행해보기
### 1. 이미지 만들기(Dockerfile)
```Docker title:'Dockerfile'
#Dockerfile
# tomcat9 & jdk8
FROM tomcat:9.0-jdk8-corretto

# 포트 열기 (톰캣 기본 포트는 8080입니다)
EXPOSE 8080

# 컨테이너 시작 시 톰캣 실행
CMD ["catalina.sh", "run"]
```

도커파일로 이미지 생성
```bash
docker build -t timg .
#docker build -t 이미지명 .
```

### 2. 컨테이너 생성
8080-8080 컨테이너 생성 후 백그라운드 실행 
```bash
docker run -d --name tcont -p 8080:8080 timg
#docker run -d --name 컨테이너명 -p 로컬포트:도커포트 이미지명
```

#### 성공!
리눅스 아이피 또는 로컬호스트에 8080 으로 접속해보면 아래처럼 404 뜸
![[Pasted image 20240516161817.png]]
docker 로 말아올린 톰캣 webapps 안에 아무것도 없기 때문에 404 뜨면 성공임

### 3. war 파일 밀어넣기
```bash
 docker cp ./CS.test.war tcont:/usr/local/tomcat/webapps
 #docker cp 말아넣을파일 컨테이너명:톰캣webapps주소
```

![[Pasted image 20240516162502.png]]
### 4. 도커 톰캣 포트 바꿔보기
- 도커파일 수정
```Docker title:'in Dockerfile'
# expose 원하는 포트로 변경 
EXPOSE 1010
```

- 도커 exec접속 후 `tomcat\conf`  에서 `server.xml ` 수정
```bash title:'in tomcat server.xml'
...	
	<Connector port="1010" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />

```
위 부분 찾아서  포트 원하는 포트로 변경

> 하지만 이미 포트는 다른곳으로 열려있는 상황,,
> 지금 수정한 도커 컨테이너를 이미지로 복사해서 새로운 포트로 연다
> (다른 방법은 아직 못찾음)

지금 도커 컨테이너로 새로운 이미지 생성
```bash
docker commit tcont img2
#docker commit 기존컨테이너 새로운이미지명
```

새로운 이미지, 새로운 포트로 컨테이너 재실행
```bash
docker run -d --name tcont2 -p 1010:1010 img2
```

기존 컨테이너 삭제
```bash
docker rm tcont
```
- 