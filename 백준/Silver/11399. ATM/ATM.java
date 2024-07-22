import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 오름차순 정렬한다
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 2. 누적합을 구한다.
        int[] S = new int[N];
        S[0] = arr[0];
        for (int i = 1; i < N; i++) {
            S[i] = arr[i] + S[i - 1];
        }

        int result = 0;
        for (int i : S) {
            result += i;
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}

