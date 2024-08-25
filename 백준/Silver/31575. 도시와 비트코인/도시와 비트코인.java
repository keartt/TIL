import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int[][] direction = new int[][]{{1, 0}, {0, 1}};
    static int [][] city;
    static boolean[][] visited;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(BFS());
    }

    private static String BFS() {
        String result = "No";

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int nowX = now[0];
            int nowY = now[1];
            for (int[] dr : direction) {
                int x = nowX + dr[0];
                int y = nowY + dr[1];
                // out of index
                if (x < 0 || x >= M || y < 0 || y >= N) {
                    continue;
                }
                // visited or can not go
                if (visited[x][y] || city[x][y] == 0) {
                    continue;
                }

                // do not use this problem
                // city[x][y] = city[nowX][nowY] + 1;
                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
        // can go last
        if (visited[M-1][N-1]){
            result = "Yes";
        }

        return result;
    }
}

