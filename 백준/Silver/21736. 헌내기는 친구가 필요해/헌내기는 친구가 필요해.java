import java.io.*;
import java.security.DrbgParameters;
import java.util.*;

public class Main {
    static boolean [][] visited;
    static String [][] campus;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        campus = new String[N][M];

        result = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                campus[i][j] = split[j];
                // I 는 1개이며, 해당 DFS 는 I, 시작점이 정해져 있다.
                if (campus[i][j].equals("I")){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        DFS(startRow, startCol);

        System.out.println(result == 0 ? "TT" : result);
    }

    static void DFS(int row, int col) {
        if (visited[row][col]) return;

        visited[row][col] = true;

        // **result 를 증가시키는 부분의 위치는 여기!!**
        // DFS 를 탐색하며, 방문한적이 아직 없는데 P 를 만난 지점은 여기이다.
        if (campus[row][col].equals("P")) {
            result++;
        }

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        for (int k = 0; k < 4; k++) {
            int goRow = row + directions[k][0];
            if (goRow > campus.length -1 || goRow < 0) continue;

            int goCol = col + directions[k][1];
            if (goCol > campus[0].length -1 || goCol < 0) continue;
            
            // TC 를 보면 만난 지점이 벽이 아니라면 또 이동할 수 있다. (+방문한적 없다면)
            if (!campus[goRow][goCol].equals("X") && !visited[goRow][goCol]) {
                DFS(goRow, goCol);
            }

        }

    }
}
