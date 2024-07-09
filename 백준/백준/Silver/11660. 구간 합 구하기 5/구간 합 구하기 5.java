import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 주어진 인덱스와 맞추기 위해 +1
        int [][] S = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());

            // 구간의 합배열 구하기
            for (int j = 1; j < N+1; j++) {
                S[i][j] = S[i][j-1] + S[i-1][j]             // +(i,j) 기준 왼쪽, 위쪽 합배열의 합
                        + Integer.parseInt(st.nextToken())  // +본인값
                        - S[i-1][j-1];                      // -겹치는 11시 방향 (i-1, j-1) 제거

            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}