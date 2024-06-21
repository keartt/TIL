package CodingTest.BAEKJOON.Silver.S3_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Idiot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] numbers = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            numbers[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());

            int sum = 0;
            for (int j = end; j >= start; j = j-2) {
                sum += numbers[j];
                if (j > start) sum += numbers[j - 1];
            }
            System.out.println(sum);
        }
    }
}

