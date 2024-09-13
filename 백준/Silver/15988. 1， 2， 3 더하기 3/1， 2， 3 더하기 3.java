import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// way1. 전부 구하고 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Long [] dp = new Long[1000000 + 1];
        dp[1] = 1L; // 1
        dp[2] = 2L; // 2, (1+1)
        dp[3] = 4L; // 3, (2+1), (1+2), (1+1+1)
        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
        while (T-- > 0) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}