
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = solution(i, j);
                if (result > count) result = count;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int solution(int startRow, int endRow) {
        String[] answer = {"BWBWBWBW", "WBWBWBWB"};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = endRow + j;
                if (board[row].charAt(col) != answer[row%2].charAt(j)){
                    count++;
                }
            }
        }
        return Math.min(count, 64 - count);
    }
}

