import java.io.*;

public class Main {
    // int 가 아닌 Integer 로 한 이유는
    // int 배열은 0 이 기본으로 들어감, 0인지 여부는 직접 넣어야 하기에
    // 기본값으로 null 이 들어가는 Integer 로 선언
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0 과 1 에 대한 값 저장
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Integer[] result;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            result = fibonacci(N);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    // DP - 메모이제이션 (Top-down approach)
    static Integer[] fibonacci(int n) {
        // 둘중 하나라도 값이 들어있지 않다면
        if (dp[n][0] == null || dp[n][1] == null) {
            // 재귀함수로 dp 에 값 저장
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }


}

