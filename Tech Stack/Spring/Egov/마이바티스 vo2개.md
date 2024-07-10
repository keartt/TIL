# 마이바티스 result 로 vo 2개 설정하기

>
> 마이바티스 환경에서 vo(dto) 가 여러개 있거나 join 으로  
> 서로 다른 컬럼을 가진 2개 이상의 테이블의 값을 조회할 때  
> 일일히 새로운 응답용 vo(dto)를 만들지 않고, 하나의 vo(dto)를 합쳐서  
> 응답을 파싱하고 결과를 표출하고 싶다.
>

## resultMap - collection 사용 예시

### vo(dto) 클래스 2개

```java
public class vo1 {
    private String col1;
    private vo2 vo2;
    // getter &  setter
}
public class vo2 {
    private String col2;
    // getter & setter
}
```

### DAO

```java
public class DAO {
    public List<vo1> test(){return selectList("test");}
}
```

### Mapper.xml (Mybatis SQL)

```xml
<!-- resultMap  -->
<resultMap id="vo11" type="vo1">
    <result property="col1" column="col1"/>
    <collection property="vo2" resultMap="vo2"/>
</resultMap>

<resultMap id="vo2" type="vo2">
    <result property="col2" column="c2"/>
</resultMap>

<!-- sql  -->
<select id="PopAnalyDAO.test" resultMap="vo11">
    select col1, col2 as c2 from yi_geo_test
</select>
```

## Step0

`vo1` 에 `vo2` 타입도 멤버변수로 선언하고,  
이를 이용해서 `vo11` 이라는 `resultMap` 을 만든다.  
그리고 `vo1` 멤버변수를 `result property, column` 으로 설정하고  
`vo2` 멤버변수로 받을 값들은 `vo2` `resultMap`을 만들고 `vo11` 안에 넣는다

## Step1

`resultMap` 내에서 `column` 속성은 실제 sql 조회 결과에 해당하는  
컬럼명 또는 `as` 로 지정한 별칭에 해당하는 값이 들어가야 함  
`property` 값에는 `type` 으로 매핑한 `vo` 에 해당하는 멤버변수명이 들어가야함

## Step2

최종적으로 `select` 에서 `resultMap` 지정할때는  
`resultMap` 선언시 사용한 `type` 이 아니라 `id` 값이 들어가야 함

https://keartt.tistory.com/entry/%EB%A7%88%EC%9D%B4%EB%B0%94%ED%8B%B0%EC%8A%A4-result-%EB%A1%9C-vo-2%EA%B0%9C-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0