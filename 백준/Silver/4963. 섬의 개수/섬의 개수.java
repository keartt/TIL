import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            arr = new int[w][h];
            visited = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        if (dfs(i, j)) {
                            count++;
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= w || newY < 0 || newY >= h) continue;
            if (!visited[newX][newY] && arr[newX][newY] == 1) {
                dfs(newX, newY);
            }
        }
        return true;
    }
}
