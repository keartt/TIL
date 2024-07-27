import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        int count = 0;
        int result = K;
        for (int i = N-1; i >= 0; i--) {
            if (result == 0) break;
            int i1 = result / arr[i];

            if (i1 > 0){
                result -= (arr[i] * i1);
                count += i1;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}