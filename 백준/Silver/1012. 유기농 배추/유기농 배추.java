import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static boolean[][] baeChu;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int result = 0;

            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            visited = new boolean[W][H];
            baeChu = new boolean[W][H];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                baeChu[w][h] = true;
            }

            // 모든 행,열 탐색
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    // 배추는 있는데 방문은 안햿으면
                    if (baeChu[j][k] && !visited[j][k]) {
                        DFS(j, k);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
    static void DFS(int row, int col){
        if (visited[row][col]) return;

        visited[row][col] = true;

        int[][] directions = {
                {0, 1},     // 상  x, y+1
                {0, -1},    // 하  x, y-1
                {-1, 0},    // 좌 x-1, y
                {1, 0}      // 우 x+1, y
        };

        for (int i = 0; i < 4; i++) {
            int nearRow = row + directions[i][0];
            //visited.length = 행의 총 크기를 의미함, 이 범위를 넘으면 안댐
            if (nearRow < 0 || nearRow > visited.length -1) continue;

            int nearCol = col + directions[i][1];
            //visited[0].length = 열의 총 크기를 의미함, 이 범위를 넘으면 안댐
            if (nearCol < 0 || nearCol > visited[0].length - 1) continue;

            if (baeChu[nearRow][nearCol] && !visited[nearRow][nearCol]) {
                DFS(nearRow, nearCol);
            }
        }

    }
}