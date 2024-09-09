import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;

    // 4 depth 상하좌우 방향
    static int[][] direction = {{0, 0, 1, -1}, {1, -1, 0, 0}};

    //중앙을 중심으로 T 모양
    static int[][][] dT = {
            {{-1,0},{1,0},{0,1}},   // ㅏ
            {{0,-1},{0,1},{1,0}},   // ㅜ
            {{0,-1},{-1,0},{1,0}},  // ㅓ
            {{0,-1},{-1,0},{0,1}}   // ㅗ
    };

    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                solution(i, j);
            }
        }
        System.out.println(ans);
    }

    static void solution(int r, int c) {
        visited[r][c] = true;
        DFS(r, c, 1, arr[r][c]);
        // 이걸 해주는 이유는 초기화 계속하면 복잡도가 너무 높아짐
        visited[r][c] = false;

        for (int[][] dt : dT) {
            int sum = arr[r][c];
            for (int[] dr : dt) {
                int x = r + dr[0];
                int y = c + dr[1];
                // 하나라도 삐꾸나면 out
                if (x < 0 || x >= N || y < 0 || y >= M) break;
                sum += arr[x][y];
            }
            ans = Math.max(ans, sum);
        }
    }

    static void DFS(int r, int c, int depth, int sum) {
        // 4 depth (모두방문 하나의 도형 완성) 일때만 ans 변경 후 종료
        if(depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = r + direction[0][i];
            int y = c + direction[1][i];
            if (x < 0 || x >= N || y < 0 || y >= M) continue;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            DFS(x, y, depth + 1, sum + arr[x][y]);
            // 이걸 해주는 이유는 초기화 계속하면 복잡도가 너무 높아짐
            visited[x][y] = false;
        }
    }

}