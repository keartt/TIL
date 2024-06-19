# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/4.svg" width="30" height="30" style="vertical-align: middle;"/> [8958] OX 퀴즈
> [2024-06-19](https://www.acmicpc.net/problem/8958)

## Question
#### 문제
``` 
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
```

### Tag
`구현`, `문자열`

--- 

## Answer

> [!tip]
> `StringTokenizer` 로 할 수 없음(공백이 없기에)
> 연속될 경우 가산점이 있고, 패배할 경우 가산점이 사라짐


| 메모리(kb) | 시간  (ms) |
|---------|----------|
| 14444   | 136       |
