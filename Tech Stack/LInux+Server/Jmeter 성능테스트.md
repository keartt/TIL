
## 설치 (윈도우, 리눅스)

```sh
wget https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.tgz
tar -xvzf apache-jmeter-5.6.3.tgz
```
> jdk 8 이상 필수
## 테스트 계획 작성
GUI 환경에서 편하게 테스트 계획 작성
- 쓰레드 그룹
	- 쓰레드(말 그대로 쓰레드, 사용자 수임)
	- Ramp-up 시간 몇초 안에 위에서 설정한 쓰레드가 실행되게 할건지
	- 루프 카운트 몇번 반복할건지
	-  `ex)` 30-10-2: 10초 내에 30명 사용자가 접속해서 쓰레드 그룹 내 컨트롤러들을 모두 순차적으로 실행을 한다. (이걸 2번 반복- 쓰레드가 2번 생성되는건 아님 생성된 쓰레드에서 컨트롤러를 2번 실행하는거임)
		
- 사용자 정의 변수 지정 후 각 요청마다 편하게 사용  `${val}`
- 쓰레드 그룹 설정
	- HTTP 쿠키 관리자 해야지 세션 등 저장됨
- 한번만 실행 컨트롤러
	- 이걸로 로그인, 인증페이지 접속 등 실행
- 단순 컨트롤러에 묶어서 하면 인증같은거 보고서에서 제외할 수 있음
- 보고서
	- 요약, 응답시간 그래프 -> 뻘 하게 많이 사용 간단하게 보기 좋음
	- 결과 트리 -> req, res 응답 보기 쉽게 나타내줌
	- 결과를 파일로 저장하게 설정(리눅스에서 뽑아오기 쉽게)
- HTTP 요청
	- HTTP 헤더 관리자를 통해 json 등 헤더 설정해줌
	- form-data 일 경우 그냥 param 으로 + `application/x-www-form-urlencoded `


> 모든 거에서 ' '공백 하나라도 들가면 오류남 주의 

## 리눅스에서 실행

위에서 만든 테스트계획 jmx 파일 리눅스로 옮긴 후 
JMeter 디렉토리에서 해당 파일로 실행

``` bash
cd ${zmeter_dir}/bin
./jmeter -n -t ../../CS.test.jmx -l ../../CS.test.jtl
```

실행 후 나온 결과를 가지고 GUI 보고서에서 보면 나옴 끄읏

```js
var a = 'aa@bb';
var b = 'b'
console.log(a,b)

var [a, b] = a.split('@');

console.log(a,b)
```