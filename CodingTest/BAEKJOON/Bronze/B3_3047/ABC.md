# ABC
> [Bronze 3] 3047

## Question
- 입력받은 세 수를 `입력받은`순서대로 출력

### Tag
`구현`

## Answer

> [!tip]
> 마지막 분류전에, 기존 입력받은 숫자도 정렬한 후에 변환하는것
> sort 등 Arrays 메소드 부족

### result
| 메모리(kb) | 시간  (ms) |
|---------|----------|
| 15828   | 116       |
---
> [!Note] 띠용한 코드
- Map 을 이렇게 쓸수도 있네
```java
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];
        for(int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
    
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', arr[0]);
        map.put('B', arr[1]);
        map.put('C', arr[2]);

        String str = sc.next();
        for(char ch : str.toCharArray())
            System.out.print(map.get(ch) + " ");
    }
```
