# Arrays 와 comparator

## Arrays.sort()
위 메소드를 사용하면 기본적으로 default `Comparator` 를 사용해 배열을 오름차순으로 정렬한다

int 형 배열에서는 위 방법을 사용하면 편리하나

문자열 에서는 Comparator 를 재정의해줘야 함 (원하는 조건에 따라)

### 내림차순 정렬 진행하는 법 
`Arrays.sort(arr, Comparator.reverseOrder());`
이때 arr 은 제네릭 타입을 가져야 함 ( 기본 자료형 불가 )

## Comparator

> [!IMPORTANT]
> `Comparator` 는 제네릭 타입을 가지며, 기본 자료형(int, double 등)에 대해서는 직접적으로 사용할 수 없음.

Comparator 메소드에서는 반환 값이 양수일 경우 첫 인자가 더 크다고 간주한다.
아래 메소드의 경우 문자열 길이 오름차순으로 정렬되며,
만약 내림차순으로 정렬하고자 한다면 `s2.length() - s1.length()` 이런식으로 진행함

- 예시코드 (문자열 길이 순으로 오름차순)
```java
Arrays.sort(arr, new Comparator<String>(){
    @Override
    public int compare(String s1, String s2){
        return s1.length() - s2.length();
    }
})
```

- 문자열 사전식 정렬 비교
`s1.compareTo(s2)`
위 방식도 역순으로 정렬하고 싶다면 s1, s2 의 위치를 바꿔주면 된다.

> 관련문제
> <img src="https://d2gd6pc034wcta.cloudfront.net/tier/6.svg" width="20" height="20" style="vertical-align: middle;"/> [[1181] 주몽](https://www.acmicpc.net/problem/1181)
