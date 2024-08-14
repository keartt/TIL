import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Long[] dp = new Long[101]; // 생각해보니까 동일한 dp를 tc 마다 돌고 같은 값이니까 걍 저장함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(recur(n)).append("\n");
        }
        System.out.println(sb);
    }

    /* dp[n] = dp[n-3] + dp[n-2] (n >= 3)
     * 2 = 1+1      dp[3] = dp[0] + dp[1]
     * 2 = 1+1      dp[4] = dp[1] + dp[2]
     * 3 = 2+1      dp[5] = dp[2] + dp[3]
     * 4 = 3+1      dp[6] = dp[3] + dp[4]
     * 5 = 4+1      dp[7] = dp[4] + dp[5]
     */
    
    private static long recur(int n) {
        if (dp[n] == null) {
            dp[n] = recur(n - 3) + recur(n - 2);
        }
        return dp[n];
    }


    /** 멍청식 계산
     * 3 = 2+1      dp[5] = dp[4] + dp[2]
     * 4 = 3+1      dp[6] = dp[5] + dp[1]
     * 5 = 4+1      dp[7] = dp[6] + dp[0]
     *
     * 7 = 2+5      dp[8] = dp[7] + dp[3]
     * 9 = 7+2      dp[9] = dp[8] + dp[4]
     *      dp[n] = dp[n-1] + dp[n-5] ( n > 7 )
     */

}