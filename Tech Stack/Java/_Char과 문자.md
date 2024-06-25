# Char, 문자열
#### change char
`str`, `chr`

- String to char
`str.charAt(0);`

- char to Int
-- 문자 0-9 까지 유효
`chr -'0';`

- char to String
`String.valueOf(chr)`

ASCII 코드
### 알파벳 대문자
시작점: 'A' `(65)`
끝점: 'Z' `(90)`

### 알파벳 소문자
시작점: 'a' `(97)`
끝점: 'z' `(122)`

### 숫자
시작점: '0' `(48)`
끝점: '9' `(57)`

문자열에서 특정 문자 검색 `indexOf() `
```java
String str = "Hello World";
int index = str.indexOf('o'); // index에는 4가 저장됩니다 (첫 번째 'o'의 위치)
```