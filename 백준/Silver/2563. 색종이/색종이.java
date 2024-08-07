import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] arr = new boolean[100][100];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // index 를 기준으로 할것이므로 -1
            int w = Integer.parseInt(st.nextToken()) -1;
            int h = Integer.parseInt(st.nextToken()) -1;
            // 가로 세로 넓이 10
            for (int j = w; j < w + 10; j++) {
                for (int k = h; k < h + 10; k++) {
                    arr[j][k] = true;
                }
            }
        }
        int result = 0;
        for (boolean[] ar : arr) {
            for (boolean a : ar) {
                if (a) result++;
            }
        }
        System.out.println(result);
    }
}