# BufferedReader와 BufferedWriter
- BufferedReader와 BufferedWriter는 입출력 속도를 개선하고, 버퍼링을 통해 많은 데이터를 효율적으로 처리할 수 있음
- 매번 입출력 스트림으로부터 데이터를 읽고 쓰는 것보다 버퍼링을 통해 오버헤드를 줄일 수 있음
- 대용량 데이터 처리를 빠르게 처리 가능

##  BufferedReader (`Scanner` 대체)

### 선언 및 사용
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
br.readLine();
```
한줄에 하나씩 `String` 값을 반환한다.

### StringTokenizer
원하는 구분자로 문자열을 구분해줌, 지정하지 않을경우 공백으로 구분
```java
StringTokenizer st = new StringTokenizer(br.readLine());

.. StringTokenizer(String str, String delim); // 구분자(delim)

.. StringTokenizer(String str, String delim, true); // 마지막 값을 true 로 하면 구분자도 토큰으로 간주함
```
- 뒤의 토큰이 더 있는지 확인 
`st.hasMoreTokens();`
- 다음 토큰 값 확인 : String
`st.nextToken();`

### EOF
st 로 마지막 더 이상 입력값이 없는지 확인하려면
(백준에서는 OK but IDE 에서는 안댐(Ctrl + D))
```java
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

String str;
while ((str = br.readLine()) != null){
    StringTokenizer st = new StringTokenizer(str);
}
```

## BufferedWriter (`System.out.println()` 대체)
### 선언
```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
```

### 사용
```java
bw.write("something" + "\n");
```
-> `+"\n` 필수로 붙여야 함

### 출력 & 버퍼 닫기 (필수!!)
```java
bw.flush();
bw.close();
```


