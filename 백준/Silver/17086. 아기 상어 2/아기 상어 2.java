import javax.naming.NoPermissionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int N, M;
    static int [][] space;
    static boolean [][] visited;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1일 경우 BFS 안들어감?
                if (space[i][j] == 1) continue;
                result = Math.max(result, BFS(i, j));
            }
        }
        System.out.println(result);
    }

    static int BFS(int r, int c) {
        // 초기화
        visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 8; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int depth = now[2] + 1; // 0 일경우 depth 하나 더해서 다음으로, 1일경우 depth 하나 더해서 리턴
                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (visited[x][y]) continue;
                if (space[x][y] == 0) {
                    que.add(new int[]{x, y, depth});
                    visited[x][y] = true;
                }else{
                    return depth;
                }
            }
        }
        return 0; // 못만남 = 0
    }
}
