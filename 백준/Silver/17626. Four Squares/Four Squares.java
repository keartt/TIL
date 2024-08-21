import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.println(solution(N));
    }
    public static int solution(int n) {
        dp[1] = 1; // 초기값 설정

        // n 까지 dp 값 insert
        for (int i = 2; i <= n; i++) {
            int min = n; // 초기값을 n으로 설정 (최댓값은 1의 제곱을 n번 더한 경우)

            // 본인보다 작거나 같은 제곱수를 탐색하며 최소값을 찾음
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j; // temp 가 0이면 dp[0] = 0, 최솟값 확정
                min = Math.min(min, dp[temp]); // 현재까지의 최소 제곱수 개수를 선택
            }
            // 그리고 제곱근 뺸 값을 구해왔으니 현재 제곱근 개수 +1
            dp[i] = min + 1;
        }
        return dp[n]; 
    }
}