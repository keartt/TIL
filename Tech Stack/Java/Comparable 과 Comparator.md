# Comparable 과 Comparator

`Comparable` 과 `Comparator` 는 모두 객체를 비교하기 위한 `인터페이스` 

`Comparable` 에는 `compareTo(T o)`(자기 자신과 매개변수 객체를 비교)

`Comparator` 에는 `compare(T o1, T o2)`(두 매개변수 객체를 비교) 메소드가 선언되어 있다

두 인터페이스 모두 <T> 제네릭 타입에 대해서만 사용이 가능하다.

> [!TIP]
> 자바에서의 비교는 기본적으로 오름차순이다
> 즉 두 원소의 비교결과가 음수일 경우 교환을 진행하지 않는다.
> 오름차순일 경우 선행원소 - 후행원소
> 내림차순일 경우 후행원소 - 선행원소

# Comparable
예시
```java
public class People implements Comparable<People>{
    // 매개변수들
    int age;
    
    public People(int age) {
        this.age = age;
    }
    
    @Override
    public int compareTo(People p){
        // 비교구현 ( 들어온 파라미터 p 에 대해 age 로 정렬)
        return this.age - p.age; 
    }
}
```
새로 만든 객체 자기자신과 매개변수 객체를 비교한다.
return 값이 양수일 경우 자기 자신이 더 큼

### 사용방법1. 객체의 비교
```java
People a = new People(1);
People b = new People(2);

a.compareTo(b) // 1 양수가 나옴
```

### 사용방법2. 배열 & List 로써의 비교

```java
ArrayList<People> p = new ArrayList<>();
p.add(new People(1));
p.add(new People(3));
p.add(new People(2));

Collections.sort(p);

People[] pp = new People[3];
pp[0] = new People(1);
pp[1] = new People(3);
pp[2] = new People(2);

Arrays.sort(pp);
```
위처럼 Comparable 를 구현해 두면, 구현해 둔 내용으로 메소드를 이용해 정렬이 가능하다.

> ![WARNING]
> 위처럼 단순하게 `-` 연산을 하는 경우 int 값의 오버플로우가 발생할 수 있기에
> 비교연산자를 통해 대소비교 후 음,양수 값을 뱉는게 안전하다.

### String 에서의 compareTo
String 클래스에서도 compareTo 메소드가 있으며, 이또한 Comparable 을 구현한 것이다.
이는 문자열의 사전식 정렬 비교를 도와주거나 크기를 비교해준다.


# Comparator
Comparable 과 달리 매개변수로 두개의 원소를 받고

이 두 원소는 자기자신과 상관이 없다. `자기 자신은 두 객체 비교에 영향이 없다`

Comparable 과 같이 사용할경우 쓸모없는 객체  가 추가된다.

비교만을 위해서 사용하는게 효율적이므로 `익명 객체(클래스)` 를 사용한다.

### 익명객체 구현 1
```java
public class Main{
    public static void main(String[] args) {
        // 익명객체 구현 (나이비교용)
        Comparator<People> ageComp = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.age - o2.age;
            }
        };
        
        // 익명객체 구현 (키 비교용)
        // 익명객체 구현
        Comparator<People> heightComp = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.height - o2.height;
            }
        };
        People p1 = new People(17, 180);
        People p2 = new People(21, 170);

        ageComp.compare(p1, p2); // -4
        heightComp.compare(p1, p2); // 10
    }
}
class People {
    int age;
    int height;
    public People(int age, int height) {  this.age = age; this.height = height;}
}
```
이를 통해 `compare` 로 두 객체를 비교할 수 있게 되고,

여러가지 비교를 구현하고자 할때 원하는 만큼만 익명객체를 만들어 비교가 가능함

### 익명객체 구현2 (배열)
```java
Arrays.sort(arr, new Comparator<String>(){
    @Override
    public int compare(String s1, String s2){
        return s1.length() - s2.length();
    }
})

Collections.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});
```
List , 배열의 sort 정렬시 두번째 매개변수로 Comparator 익명함수를 사용해

원하는 방식으로 정렬을 진행할 수 있다.

> 관련문제
> <img src="https://d2gd6pc034wcta.cloudfront.net/tier/6.svg" width="20" height="20" style="vertical-align: middle;"/> [[10814] 나이순 정렬](https://www.acmicpc.net/problem/10814)


> [참고출처](https://st-lab.tistory.com/243)