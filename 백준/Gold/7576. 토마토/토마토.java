import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean [][] visited;
    static Integer[][] tomatoes;
    static int X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visited = new boolean[X][Y];
        tomatoes = new Integer[X][Y];
        List<int[]> start = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    visited[i][j] = true;
                } else if (num == 1) {
                    start.add(new int[]{i, j});
                }
                tomatoes[i][j] = 0; // only null or 0
            }
        }
        BFS(start);

        int result = getResult();
        System.out.println(result);
    }

    private static int getResult() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visited[i][j]) { // && tomatoes[i][j] == 0 : 토마토가 0인데 방문 안한거
                    return -1;
                }
                if (tomatoes[i][j] > max) {
                    max = tomatoes[i][j];
                }
            }
        }
        return max;
    }

    // 굳이 두번 돌릴 필요없이 큐 이므로 시작점 한번에 큐에 넣고 시작하면 댐
    private static void BFS(List<int[]> start) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] s : start) {
            visited[s[0]][s[1]] = true;
            queue.add(s);
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];
                if (x < 0 || x >= X || y < 0 || y >= Y) continue;

                // 방문 안했을때 또는
                // 방문 했는데, 해당 값이 지금 넣으려는 값보다 크면
                if (!visited[x][y] || (visited[x][y] && tomatoes[x][y] > tomatoes[nx][ny] + 1)) {
                    tomatoes[x][y] = tomatoes[nx][ny] + 1;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    //for (int[] arr : start) {
    //    BFS(arr[0], arr[1]);
    //}
    static void BFS_timeOut(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        // 지금 시작점을 다른 데서 먼저 방문해서 값을 올렸을 수도 있기에 값 초기화
        tomatoes[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];
                if (x < 0 || x >= X || y < 0 || y >= Y) continue;

                // 방문 안했을때 또는
                // 방문 했는데, 해당 값이 지금 넣으려는 값보다 크면
                if (!visited[x][y] || (visited[x][y] && tomatoes[x][y] > tomatoes[nx][ny] + 1)) {
                    tomatoes[x][y] = tomatoes[nx][ny] + 1;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

    }
}