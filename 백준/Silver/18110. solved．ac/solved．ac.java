
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = (int) Math.round(N * 0.15);
        double result = 0;

        for (int i = min ; i < N - min; i++) {
            result += arr[i];
        }
        result = Math.round(result / (N - (min * 2)));
        bw.write((int) result + "\n");

        bw.flush();
        bw.close();
    }
}