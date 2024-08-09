import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean [][] visited;
    static int [][] arr;
    static int[] target;
    static int w,h;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        visited = new boolean[w][h];
        arr = new int[w][h];
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < h; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    target = new int[]{i, j};
                    arr[i][j] = 0;   // 값 편하게 구하기 위해 target 에  0 삽입함 (target 은 한번만 찍으니 노상관)
                }else if (num ==0){
                    // 못가면 방문했다고 가정해도 되지 않음?
                    visited[i][j] = true;
                }else{
                    arr[i][j] = num;
                }
            }
        }

        BFS(target[0], target[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int result;
                if (!visited[i][j] && arr[i][j] == 1) {
                    result = -1; // 방문못했는데, 갈 수 있던 곳
                }else{
                    result = arr[i][j];
                }
                sb.append(result).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        // 방문하지 않았고, 값이 1일때만
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];
                if (x >= 0 && x < w && y >= 0 && y < h) {
                    if (!visited[x][y]) {
                        // +1 depth
                        arr[x][y] = arr[nowX][nowY] + 1;
                        // visited check here
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }

            }
        }
    }
}