import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char [][] colors;
    static boolean [][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                colors[i][j] = chars[j];
            }
        }

        // dfs
        System.out.print(solve());

        // change Red to Green
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (colors[i][j] == 'R') {
                    colors[i][j] = 'G';
                }
            }
        }

        // dfs again
        System.out.println(" " +solve());
    }

    static void DFS(int r, int c) {
        visited[r][c] = true;
        char color = colors[r][c];

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            if (!visited[x][y] && color == colors[x][y]) {
                DFS(x, y);
            }
        }
    }

    static int solve() {
        int count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i,j);
                    count++;
                }
            }
        }
        return count;
    }
}