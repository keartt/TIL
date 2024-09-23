import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int max = 1;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) arr[i][j] = str[j];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) { // 범위 내에서 오른쪽과 교환
                    swap(i, j, i, j + 1);
                    updateMax(i, j, false);
                    swap(i, j + 1, i, j); // 원상 복구
                }
                if (i + 1 < N) { // 범위 내에서 아래쪽과 교환
                    swap(i, j, i + 1, j);
                    updateMax(i, j, true);
                    swap(i + 1, j, i, j); // 원상 복구
                }
            }
        }
        System.out.println(max);
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char tmp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = tmp;
    }

    static void updateMax(int r, int c, boolean isRow) {
        max = Math.max(max, chkRow(r));
        max = Math.max(max, chkCol(c));
        if (isRow) {
            max = Math.max(max, chkRow(r + 1));
        } else{
            max = Math.max(max, chkCol(c + 1));
        }
    }

    static int chkRow(int r) {
        int depthMax = 1;
        int depth = 1;
        char chk = arr[r][0];
        for (int i = 1; i < N; i++) {
            if (arr[r][i] == chk) {
                depth++;
            } else {
                depthMax = Math.max(depthMax, depth);
                depth = 1;
                chk = arr[r][i];
            }
        }
        return Math.max(depthMax, depth);
    }

    static int chkCol(int c) {
        int depthMax = 1;
        int depth = 1;
        char chk = arr[0][c];
        for (int i = 1; i < N; i++) {
            if (arr[i][c] == chk) {
                depth++;
            } else {
                depthMax = Math.max(depthMax, depth);
                depth = 1;
                chk = arr[i][c];
            }
        }
        return Math.max(depthMax, depth);
    }
}
