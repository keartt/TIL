
import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        Arrays.sort(arr);

        // 최빈값
        int many = arr[0];
        int count = 0;
        int maxCount = -1;
        boolean isSecond = false;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 0;
            }

            if (maxCount < count) {
                maxCount = count;
                many = arr[i];
                isSecond = false;
            } else if (maxCount == count && !isSecond) {
                isSecond = true;
                many = arr[i];
            }

        }
        
        sb.append(Math.round((double) sum / N)).append("\n"); // 산술평균
        sb.append(arr[N / 2 ]).append("\n"); // 중앙값
        sb.append(many).append("\n");
        sb.append(max - min); // 범위

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}