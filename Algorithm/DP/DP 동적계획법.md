# 동적 계획법 (DP - Dynamic Programming)

> 동적 계획법 (DP - Dynamic Programming) 은 큰 문제를 작은 문제로 나누어서 풀이하는 방식의 알고리즘

## 분할 정복과의 차이점
주어진 문제를 더 작은 문제들로 나눈 뒤, 작은 문제들의 답을 구하고
원래 문제에 대한 답을 구한다는 점에서는 분할 정복 ( Divide Conquer )과 비슷함

> 차이점은 나눠진 작은 문제들이 분할 정복에서는 중복되지 않지만 
> 동적 계획법에서는 `중복될 수 있다`는 점입니다.

동적 계획법은 어떤 부분 문제는 두 개 이상의 문제를 푸는 데 사용될 수 있기 때문에
답을 한 번만 계산하고 그 결과를 여러 번 사용하여 속도를 향상할 수 있습니다.

이때 이미 `계산한 값을 저장해 두는 메모리를 캐시(Cache)` 라고 하고,
두 번 이상 계산되는 부분 문제를 `중복되는 부분 문제 (Overlapping Subproblems)` 라고 합니다.

## Overlapping Subproblem: 겹치는 부분 문제
어떤 문제가 여러 개의 부분 문제로 나눠질 수 있는 문제

> 부분 문제란?
> 항상 새로운 부분 문제 sub problem을 생성하기 보다
> 계속해서 같은 sub problem이 여러번 재사용되거나 재귀 알고리즘을 통해 해결되는 문제

## Optimal Substructure: 최적 부분구조
어떤 문제의 최적의 해결책이 그 부분 문제의 최적의 해결책으로부터 만들어질 수 있는 경우입니다.
최적 부분구조일 때는 정답을 쪼개진 작은 문제의 정답에서부터 구할 수 있습니다.

문제의 크기에 상관없이 어떤 하나의 `문제 정답은 일정`합니다. 
이 때 어떤 하나의 문제는 중복되는 문제입니다. 
중복되는 문제의 값을 매번 구하는 것은 매우 비효율적입니다. 
이러한 비효율성을 개선할 수 있는 방법은 `메모이제이션 (Memoization)`입니다.

## 메모이제이션 (Memoization)
동적 계획법에서 각 문제는 한 번만 풀이 (중복 부분도)
동적 계획법은 `Optimal Substructure`를 만족하기 때문에, 같은 문제는 정답이 같다. 
-> 정답을 한 번 구하면 그 정답을 `캐시 (Cache) 에 메모`해놓습니다. 
이는 배열에 저장하는 것으로 구현할 수 있습니다. `dp[]`


## 동적 계획법 구현
### Top-down
큰 문제를 작은 문제로 쪼개면서 해결, 재귀로 구현합니다.

### Bottom-up
작은 문제부터 차례대로 해결, 반복문으로 구현합니다.


> [출처](https://codeinleonis.tistory.com/28)