package CodingTest.BAEKJOON.Gold.G3_10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long[] S = new long[N];
        S[0] = Integer.parseInt(st2.nextToken());
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st2.nextToken());
        }
        long result = 0;

        // 나머지가 같은애들 개수를 세기 위한 배열
        // 나머지는 나누는 수 보다 작으므로 배열 크기는 M
        long[] C = new long[M];
        // 3으로 나눈 나머지 계산
        for (int i = 0; i < N; i++) {
            int remain = (int) (S[i] % M);
            // 일단 나머지가 0 인건 답이니까 추가
            if (remain ==0) result++;
            // 나머지가 같은애들 새로운
            C[remain]++;
        }

        for (int i = 0; i < M; i++) {
            // 나머지가 같은개 2개 이상일떄
            if (C[i] > 1) {
                // 해당 나머지의 개수중에서 2개를 뽑는다 C(n, 2)
                // 이거는 곧 n * (n-1) /2
                result += C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(result);
    }
}
