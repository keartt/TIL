import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N 은 1 이상이므로 N+1 배열을 선언함으로써 dp[1] 까지 기본값 세팅할 수 있도록 함
        long[] dp = new long[N + 1];
        // dp[2] 가 2 이고 이후 피보나치와 동일한 패턴을 띄므로 dp[0] 에 1값 저장
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[N]);
        
        /* 2*n = 세로 2 가로 n
        ref. 2*1 = h  , 1*2 = w
        *1 = h => 1
        *2 = (h2) , (w2) => 2
        *3 = (h3), ( w2 + h1), (h1, w2) => 3
        *4 = (h4), (w4), (w2+h2), (h2, w2), (h1 w2 h1 ) => 5
        ...
        *5 = *4 + *3  : 8
        *6 = 13
        *7 = 21
        *8 = 34
        ...
        *9 = 55 (TC 에서 말한 정답임)
         */

    }
}
