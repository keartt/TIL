package Algorithm.TwoPointer.G4_1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        for (int k = 0; k < N; k++) {
            int start = 0;
            int end = N - 1;
            long findVal = arr[k];

            while (start < end) {
                long value = arr[start] + arr[end];
                if (value == findVal) {
                    if (k == start) {
                        start++;
                    } else if (k == end) {
                        end--;
                    } else {
                        result++;
                        break;
                    }
                } else if (value < findVal) {
                    start++;
                } else { // value > findVal
                    end--;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}