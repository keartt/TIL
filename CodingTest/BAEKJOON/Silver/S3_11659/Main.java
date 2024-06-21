package CodingTest.BAEKJOON.Silver.S3_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        // 구간합 배열을 만든다.
        int[] S = new int[N];
        S[0] = Integer.parseInt(st2.nextToken());
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken()) - 1;
            int end = Integer.parseInt(st3.nextToken()) - 1;

            // 시작이 그대로일경우 구간합의 인덱스 값을 그대로 리턴하면댐
            if (start == 0) System.out.println(S[end]);
            // 시작인덱스가 아닌 시작인덱스 -1!!
            else System.out.println(S[end] - S[start-1]);
        }
    }
}
