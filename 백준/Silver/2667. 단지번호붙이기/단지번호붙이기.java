import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int N, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] input = new char[N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                // convert to Integer
                int num = input[j] - '0';
                if (num == 0) {
                    visited[i][j] = true;
                }
            }
        }

        List<Integer> group = new ArrayList<>();
        // 방문하지 않은 곳을 찾아 BFS 를 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 0;
                    DFS(i, j);
                    group.add(count);
                }
            }
        }
        // 얻은 그룹 개수, 각 값 정렬 후 출력
        StringBuilder sb = new StringBuilder(group.size() + "\n");
        Collections.sort(group);
        for (Integer i : group) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int r, int c) {
        count++;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            // out of index
            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            // visited
            if (visited[x][y]) continue;
            // recur
            DFS(x, y);
        }
    }

    private static int BFS(int r, int c) {
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            // 하나 들어올때마다 +1
            count++;
            int[] now = queue.remove();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];
                // out of index
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                // visited
                if (visited[x][y]) continue;
                // add q
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return count;
    }
}