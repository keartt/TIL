import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (N > 1) dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= N; i++) {
            // 지금꺼 안마시는경우 (이전까지의 최댓값)
            int a = dp[i - 1];
            // 지금꺼 마시는데 그전꺼 안마시는 경우
            int b = dp[i - 2] + arr[i];
            // 지금꺼 마시고 그전꺼도 마시는 경우
            int c = dp[i - 3] + arr[i - 1] + arr[i];

            dp[i] = Math.max(a, Math.max(b, c));
        }
        System.out.println(dp[N]);
    }
}