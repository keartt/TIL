package Algorithm.TwoPointer.G4_1253;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BadCase {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        boolean[] dupl = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];
                for (int k = 0; k < N; k++) {
                    if (sum == arr[k] && !dupl[k]) {
                        dupl[k] = true;
                        bw.write("sum:" + sum + ", k:" + k + ", i:" + (arr[i]) + ", j: " + (arr[j]) + "\n");
                        result++;
                    }

                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
