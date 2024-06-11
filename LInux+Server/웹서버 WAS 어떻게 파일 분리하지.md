
> [!faq]-  일단 nginx / tomcat 구성으로 봐보자
> 웹서버에는 정적 html 파일을 두고 WAS 에는 api, DB Access 로직 등을 담당하는 파일을 둔다고 배움
>그러면 실제로 정적 html 파일들은 다 웹서버에 두고 was 에는 jar 파일만 두나?
>어떻게 분리해야하지?
>리액트일 경우에는? 



## 리버스 프록시







https://haengsin.tistory.com/114


## GPT (nginx & tomcat)
Nginx와 Tomcat을 연동할 때, Nginx가 정적 파일을 처리하고 동적 요청은 Tomcat(WAS)으로 전달하는 설정은 매우 일반적입니다. 이를 통해 Nginx의 성능을 최대한 활용하고 Tomcat은 동적 요청 처리에 집중할 수 있습니다.

### Nginx와 Tomcat 연동 설정

1. **Nginx 설정**: 정적 파일을 직접 제공하고, 동적 요청을 Tomcat으로 프록시합니다.
2. **Tomcat 설정**: 정적 파일 경로를 Nginx가 접근할 수 있도록 설정합니다.

### Nginx 설정 예시

Nginx 설정 파일 (**nginx.conf**) 또는 사이트별 설정 파일)에서 다음과 같이 설정할 수 있습니다:


```bash title:'nginx'
server {
    listen 80;
    server_name example.com;

    # 정적 파일 제공
    location /static/ {
        alias /path/to/tomcat/webapps/ROOT/static/;  # Tomcat의 정적 파일 경로를 alias로 설정
    }

    # 동적 요청을 Tomcat으로 프록시
    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}
```


### Tomcat 설정

Tomcat은 정적 파일을 Nginx가 접근할 수 있는 경로에 두어야 합니다. 예를 들어, `webapps/ROOT/static/`에 정적 파일을 두고, Nginx가 이를 직접 제공하도록 설정할 수 있습니다.

### 정리

- **Nginx**: 정적 파일을 직접 제공하고, 동적 요청은 Tomcat으로 프록시합니다.
- **Tomcat**: 동적 요청을 처리합니다. 정적 파일은 Nginx가 직접 제공하도록 설정합니다.

### 동작 방식

1. **정적 파일 요청**:
    - 클라이언트가 `http://example.com/static/example.html`을 요청하면, Nginx는 `/path/to/tomcat/webapps/ROOT/static/example.html` 파일을 직접 제공합니다.
2. **동적 요청**:
    - 클라이언트가 `http://example.com/api/data`를 요청하면, Nginx는 이를 `http://localhost:8080/api/data`로 프록시하여 Tomcat이 처리하도록 합니다.

### 예시 구성

#### 파일 구조 예시

```
/path/to/tomcat/webapps/ROOT/
├── index.html
└── static
    ├── css
    │   └── style.css
    └── js
        └── script.js

```

#### Nginx 설정 파일 (`nginx.conf` 또는 사이트별 설정 파일)


```bash title:'nginx'
server {
    listen 80;
    server_name example.com;

    # 정적 파일 제공
    location /static/ {
        alias /path/to/tomcat/webapps/ROOT/static/;
    }

    # 기본 경로로 접속 시 index.html 제공
    location / {
        root /path/to/tomcat/webapps/ROOT;
        index index.html;
        try_files $uri $uri/ @tomcat;
    }

    # 동적 요청을 Tomcat으로 프록시
    location @tomcat {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}
```


### 설정 적용 및 확인

1. Nginx 설정 파일을 저장합니다.
    
2. Nginx를 재시작하여 설정을 적용합니다:
    
    bash
    
    코드 복사
    
    `sudo systemctl restart nginx`
    
3. 브라우저에서 `http://example.com/`와 `http://example.com/static/example.html` 등을 접속하여 정적 파일과 동적 요청이 정상적으로 처리되는지 확인합니다.
    

이 설정을 통해 Nginx는 정적 파일을 직접 처리하고, 나머지 요청은 Tomcat으로 프록시하여 처리할 수 있습니다. 이를 통해 각 서버의 역할을 최적화하고 성능을 향상시킬 수 있습니다.