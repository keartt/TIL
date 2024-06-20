package CodingTest.BAEKJOON.Silver.S2_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = arr[i];
        }
        long min = 1;
        long answer = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += arr[i] / 2;
            }

            if (count >= N) {
                max = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}



