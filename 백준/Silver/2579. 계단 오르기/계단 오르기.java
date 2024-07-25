import java.io.*;

public class Main {
    static int [] stairs;
    static Integer [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1]; // 0칸 시작임
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = stairs[1];
        // recur 에서 n-3 을 하기에 3 이상이어야 함
        // 2일때는 무조건 1,2 를 밟는게 가능하고 가장 큼
        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        bw.write(recur(N) + "\n");
        bw.flush();
        bw.close();
    }

    static int recur(int n) {
        // 최댓값을 구해야 하는문제
        // 각 칸마다 얻을 수 있는 최댓값을 저장해 두면 되지 않을까?
        // Math.max(1-2-4, 2-4)

        // 일단 마지막을 찍어야 하니까 N 을 인자값으로 호출

        // -1 값과 비교하면 재귀 시 -1 이 계속해서 연속 발생
        // 그렇다면 -1 은 -2와 함께 비교해야 한다
        // 따라서 -2 값과 -3(-1,-2) -1 값 비교

         if (dp[n] == null) {
            int way1 = recur(n - 2);
            int way2 = recur(n - 3) + stairs[n - 1];
            dp[n] = Math.max(way1, way2) + stairs[n]; // 현재 칸 점수 더함
        }
        return dp[n];
    }
}