import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int MOD = 1000000007;
        long[] dp = new long[N + 1];

        // A/3 + B/3 = (A+B)/3
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i >= M){
                dp[i] = (dp[i] + dp[i - M]) % MOD;
            }
        }
        System.out.println(dp[N]);

    }
}
