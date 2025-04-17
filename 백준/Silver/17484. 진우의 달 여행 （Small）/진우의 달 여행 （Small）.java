import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1};
    static int[][] arr;
    static int N, M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 값 초기화
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < M; y++) {
            dfs(0, y, -1, arr[0][y]);	// 0행의 모든 열(y)에서 탐색 시작
        }
        System.out.println(result);
    }

    private static void dfs(int nowX, int nowY, int dir, int sum) {
        if (nowX == N - 1) {
            result = Math.min(result, sum);   // 현재까지의 합 누적
            return;
        }

        for (int i = 0; i < 3; i++) {   // 방향별 탐색
            int newX = nowX + 1;
            int newY = nowY + dy[i];

            if (dir == i || newX < 0 || newX > N - 1 || newY < 0 || newY > M - 1)
                continue;

            dfs(newX, newY, i, sum + arr[newX][newY]);
        }
    }
}
