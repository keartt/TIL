// ver2 bottom-up
import java.io.*;

public class Main {
    static Integer [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1]; // 0~N
        dp[0] = dp[1] = 0; // 문제 조건에 맞는 기본값 세팅

        //int answer = recur(N);      // top down
        int answer = iter(N);     // bottom up

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    // 재귀함수 Top down
    static int recur(int n) {
        // 비어있는 dp 값 채우기
        if (dp[n] == null) {
            int count; // 구해야 하는 건 횟수임
            if (n % 6 == 0) {
                // 3으로 나눴을 때 결과, 2로 나눴을 때 결과, 1 뺏을 때 결과 중 젤 작은거
                count = Math.min(recur(n / 3), recur(n / 2));
                count = Math.min(count, recur(n - 1));
            } else if (n % 3 == 0) {
                // 3로 나눴을 때 결과, 1 뺏을 때 결과 중 젤 작은거
                count = Math.min(recur(n / 3), recur(n - 1));
            } else if (n % 2 == 0) {
                count = Math.min(recur(n / 2), recur(n - 1));
            } else {
                count = recur(n - 1);
            }
            // 위 조건문을 수행했다는건, 한번 연산을 수행했다는것
            dp[n] = count + 1;
        }
        return dp[n];
    }

    // 반복 Bottom-up
    static int iter(int n) {
        for (int i = 2; i <= n; i++) {
            int count = dp[i - 1];

            // else 문이 아닌 if 문 2개, 조건이 맞다면 둘다 수행한다 (recur 에서 `n%6==0` 과 유사)
            if (i % 2 == 0) count = Math.min(count, dp[i / 2]);
            if (i % 3 == 0) count = Math.min(count, dp[i / 3]);

            dp[i] = count + 1;

            // count 를 사용하지 않고 바로 dp 계산시에는 현재 수행한것이기에 +1 과 값을 비교해야함
//            dp[i] = dp[i - 1] + 1;
//            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
//            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        return dp[n];
    }
}



