
설치(전역설치)
```bash
npm install forever -g
```

실행중인 forever 목록 확인
```bash
[myname@localhost node]$ forever list
info:    Forever processes running
data:        uid  command                    script forever pid     id logfile                       uptime
data:    [0] 4LxZ /usr/local/nodejs/bin/node app.js 2420048 2420055    /home/myname/.forever/4LxZ.log 0:0:0:2.899
```
> 여기서 uid 왼쪽의[이거숫자] 로 컨트롤 가능

forever 죽이기
```bash
forever stop 0
```

forever 로그보기
```bash
#way1
forever logs 0

#way2
vi /home/myname/.forever/4LxZ.log
```

[[우분투 포트 죽이기]]
