import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr;
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            double sum = 0;

            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[j] = val;
                sum += val;
            }

            double mean = (sum / N);
            double count = 0;

            for (int j = 0; j < N; j++) {
                if (arr[j] > mean) {
                    count++;
                }
            }

            bw.write(String.format("%.3f%%\n", (count / N) * 100));
        }

        bw.flush();
        bw.close();
    }
}
