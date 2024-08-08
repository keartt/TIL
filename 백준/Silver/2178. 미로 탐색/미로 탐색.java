import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean [][] visited;
    static int [][] miro;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(line.substring(j, j + 1));
                miro[i][j] = num;
            }
        }

        // 0,0 에서 시작
        BFS(0, 0);
        // 마지막 인덱스에 저장된 값(depth) 출력
        System.out.println(miro[N - 1][M - 1]);
    }

    private static void BFS(int row, int col) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                // 배열의 인덱스 범위 내에 있는가?
                if (x >= 0 && x < N && y >= 0 && y < M){
                    // 방문하지 않았고, 값이 0이 아닌가?
                    if (!visited[x][y] && miro[x][y] != 0) {
                        // 조건이 모두 만족한다면 다음 depth 진행(반복)을 위해 x,y를 q에 넣는다
                        queue.add(new int[]{x, y});
                        // 방문여부 체크
                        visited[x][y] = true;
                        // 그리고 한칸 지나왔으니 이전 칸의 값에 +1 을 한다 1->2 ... 2->3 ..
                        miro[x][y] = miro[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}