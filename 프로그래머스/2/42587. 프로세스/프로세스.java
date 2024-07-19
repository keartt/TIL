import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 내림차순 우선순위 큐
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities) q.add(i);

        // for 문만쓰면 우선순위 배열 첫값이 최대가 아니면 구할 수 없음 
        // q 를 모두 비워낼때까지 반복
        while (!q.isEmpty()) {
            for(int i = 0; i < priorities.length; i++){
                // 큐의 맨 앞 값(가장 높은 우선순위) 과 우선순위 배열의 값 비교
                if (q.peek() == priorities[i]) {
                    q.remove();
                    answer++;
                    // 찾고자 하는 값이 나오면 바로 반환함
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}