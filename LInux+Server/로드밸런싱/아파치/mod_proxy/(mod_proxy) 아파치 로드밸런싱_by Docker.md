
> 테스트용 서로 다른 war 파일 두개 생성 후 진행
>서버 직접 만들고 설정보단 도커 이용하는게 간단하여 이렇게 진행함

#### 디렉토리 구조
```bash 
.
├── docker-compose.yml
├── was
│   ├── Dockerfile
│   ├── was1.war
│   └── was2.war
└── webserver
    ├── Dockerfile
    ├── httpd-vhosts.conf
    └── httpd.conf
```

##### WAS(tomcat) DockerFile
``` dockerfile title:'was'
FROM tomcat:9.0-jdk8-corretto
EXPOSE 8080
CMD ["catalina.sh", "run"]
```
톰캣-jdk 버전 맞게 설치 후 실행 (war 파일은 compose 파일에서 부여함)

#### WebServer(Apache) DockerFile
``` dockerfile title:'was'
FROM httpd:2.4
  
# 커스텀 설정파일
COPY httpd.conf /usr/local/apache2/conf/httpd.conf
COPY httpd-vhosts.conf /usr/local/apache2/conf/extra/httpd-vhosts.conf

# 로그 디렉토리 생성
RUN mkdir -p /usr/local/apache2/logs && chmod -R 755 /usr/local/apache2/logs

EXPOSE 80
```

1. http 이미지 받기
2. 설정완료한 httpd.conf 파일과 httpd-vhosts.conf 파일 복사(바꿔끼기)
3. 로그 디렉토리 생성( 보기편하게 하기 위해)

#### httpd.conf 파일
mod_proxy 와 mod_proxy_ajp 등 설정 해제 -> [[httpd.conf]] [이분꺼 참고함](https://github.com/AKSarav/Docker-Httpd-Reverseproxy/blob/master/httpd.conf)
아래 코드 내용들 찾아서 주석 해제하면 됨 
```conf title:'httpd.conf'
LoadModule watchdog_module modules/mod_watchdog.so
LoadModule proxy_module modules/mod_proxy.so
LoadModule proxy_connect_module modules/mod_proxy_connect.so
LoadModule proxy_ftp_module modules/mod_proxy_ftp.so
LoadModule proxy_http_module modules/mod_proxy_http.so
LoadModule proxy_fcgi_module modules/mod_proxy_fcgi.so
LoadModule proxy_scgi_module modules/mod_proxy_scgi.so
LoadModule proxy_uwsgi_module modules/mod_proxy_uwsgi.so
LoadModule proxy_fdpass_module modules/mod_proxy_fdpass.so
LoadModule proxy_wstunnel_module modules/mod_proxy_wstunnel.so
LoadModule proxy_ajp_module modules/mod_proxy_ajp.so
LoadModule proxy_balancer_module modules/mod_proxy_balancer.so
LoadModule proxy_express_module modules/mod_proxy_express.so
LoadModule proxy_hcheck_module modules/mod_proxy_hcheck.so
LoadModule slotmem_shm_module modules/mod_slotmem_shm.so
LoadModule ssl_module modules/mod_ssl.so
LoadModule lbmethod_byrequests_module modules/mod_lbmethod_byrequests.so
LoadModule lbmethod_bytraffic_module modules/mod_lbmethod_bytraffic.so
LoadModule lbmethod_bybusyness_module modules/mod_lbmethod_bybusyness.so
LoadModule lbmethod_heartbeat_module modules/mod_lbmethod_heartbeat.so

Include conf/extra/httpd-vhosts.conf
```

#### httpd-vhosts.conf 파일
기존 파일 전체 주석 후 아래 내용 추가

```conf title:'httpd-vhosts.conf'
<VirtualHost *:80>
    ServerName localhost
    ServerAdmin webmaster@localhost
  
    # Load balancing configuration
    <Proxy "balancer://mycluster">
        BalancerMember http://was1:8080
        BalancerMember http://was2:8080
        # ProxySet lbmethod=byrequests
    </Proxy>

    ProxyPass "/" "balancer://mycluster/"
    ProxyPassReverse "/" "balancer://mycluster/"
  
    ErrorLog /usr/local/apache2/logs/error.log
    CustomLog /usr/local/apache2/logs/access.log combined
</VirtualHost>
```
docke  서비스명 was1, was2 그대로 사용 가능


#### docker-compose.yml
```yml tilte:'docker-compose.yml'
version: '3'

services:
  was1:
    build: ./was
    ports:
      - "8081:8080"
    volumes:
      - ./was/was1.war:/usr/local/tomcat/webapps/ROOT.war
  was2:
    build: ./was
    ports:
      - "8082:8080"
    volumes:
      - ./was/was2.war:/usr/local/tomcat/webapps/ROOT.war

  apache:
    build: ./webserver
    ports:
      - "80:80"
    depends_on:
      - was1
      - was2
```
###### was1, was2 
1. 위에서 만든 was 도커 파일 이용해서 톰캣 실행 
2. 각 war 를 ROOT 로 이름 변경하여 / 경로에서 실행
3. 포트는 8081, 8082 로 보기 쉽게 설정

##### apache
apache 도커파일 활용하여 웹서버 80 포트에 실행
was1, was2 서비스 의존 종속성 정의


#### Run & Test
```bash
docker-compose up -d --build
```


