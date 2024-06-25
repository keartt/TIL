# Map 반복하는법

#### 1번 람다
>  lamda 에서는 외부 변수 선언 불가, fianl/effective final... AutomicReference ... ?
```
  map.forEach((key, value)->{
      System.out.println( String.format("키 -> %s, 값 -> %s", key, value) );
  });
```

#### 2번
```
  Iterator<String> keys = map.keySet().iterator();
  while( keys.hasNext() ){
      String key = keys.next();
      System.out.println( String.format("키 -> %s, 값 -> %s", key, map.get(key)) );
  }
```

#### 3번
```
  for( Map.Entry<String, String> elem : map.entrySet() ){
      System.out.println(elem.getKey());
      System.out.println(elem.getValue());
  }
```

#### 4번
```
  for( String key : map.keySet() ){
      System.out.println(key);
      System.out.println(map.get(key));
  }
```