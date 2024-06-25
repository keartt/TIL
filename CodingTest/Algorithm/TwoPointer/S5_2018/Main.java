package CodingTest.Algorithm.TwoPointer.S5_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;

        int sum = 1;    // 시작 시 첫 숫자, 즉 1을 더한값을 가지고 시작함
        int count = 0;

        while (end < N) {
            if (sum == N){
                count++;
                // 점점 커지면서 N 까지 왔기에 다음 단계를 위해서는
                // sum < N 과 같은 조건을 줘야 함
                end++;
                sum += end;
            } else if (sum < N) {
                end++;
                sum += end;
            } else{ // sum > N
                // start 를 뒤로 미루기 때문에 start 값을 먼저 뺀 sum 을 구함
                sum -= start;
                // N 보다 커졌으니 end 는 더 키우지말고 start 를 하나 뒤로 미룬다
                start++;
            }
        }

        // N 그 자체는 제외하나 결과에는 포함시키기에 초기 count + 1;
        System.out.println(++count);
    }
}
