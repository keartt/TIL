# 자바에서의 문자
# String 과 StringBuilder(StringBuffer)

## String 은 불변 
`할당된 공간은 불변하다` 의 특징이 있음
```java
String str = "hello";
str += " world";
```
위와같은 상황에서 String 은 아래와 같이 새로운 메모리 영역을 만들고 참조한다.
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FOngYs%2FbtrJNkniOBK%2FKj8NYtK9neoy1JKqxs8Yh1%2Fimg.png">

## StringBuffer / StringBuilder 는 가변(mutable)
- StringBuffer 는 buffer 라는 별도 독립공간을 통해 문자열을 바로 추가 가능
- String 처럼 새로운 객체를 만드는 것이 아닌, 가변적으로 문자열의 크기를 변경한다
- 이로 인해 String 보다 처리가 빠름

## 문자열 값 비교는 어떻게?
String 의 경우 `str.equals(str2)` 와 같이 `equals` 메소드를 통해 가능함
StringBuffer/StringBuilder 는 객체를 String 으로 변환(`toString()`) 후 `equals` 

## 문자열 합칠때 `+`?
문자열 합칠때 String 에서 + 를 사용하면 내부적으로 StringBuilder 를 만든후 문자열로 리턴함
but 여러 문자일경우에는 매번 새로운 객체를 생성하기에 차라리 그냥 StringBuilder 를 만드는게 나음 

> [!tip]
> StringBuffer 와 StringBuilder 는 내부 메소드도 동일하다
> 하지만 Buffer 는 멀티 스테드 환경에서 유리하고
> Builder 는 무자열 파싱 성능이 우수하다는 차이점이 있음

## StringBuffer 메소드 정리

```java
String str = "abcdefg";
StringBuffer sb = new StringBuffer(str); // String -> StringBuffer

System.out.println("처음 상태 : " + sb); // 처음상태 : abcdefg

System.out.println("문자열 String 변환 : " + sb.toString()); // StringBuffer를 String으로 변환하기

System.out.println("문자열 추출 : " + sb.substring(2,4)); // 문자열 추출하기

System.out.println("문자열 추가 : " + sb.insert(2,"추가")); // 문자열 추가하기

System.out.println("문자열 삭제 : " + sb.delete(2,4)); // 문자열 삭제하기

System.out.println("문자열 연결 : " + sb.append("hijk")); // 문자열 붙이기

System.out.println("문자열의 길이 : " + sb.length()); // 문자열의 길이구하기

System.out.println("용량의 크기 : " + sb.capacity()); // 용량의 크기 구하기

System.out.println("문자열 역순 변경 : " + sb.reverse()); // 문자열 뒤집기

System.out.println("마지막 상태 : " + sb); // 마지막상태 : kjihgfedcba

```

> [출처 인파]( https://inpa.tistory.com/entry/JAVA-☕-String-StringBuffer-StringBuilder-차이점-성능-비교)