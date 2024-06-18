package CodingTest.BAEKJOON.Silver.S4_3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class idiot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer groupCount = new StringTokenizer(br.readLine());
        int N1Cnt = Integer.parseInt(groupCount.nextToken());
        int N2Cnt = Integer.parseInt(groupCount.nextToken());

        String N1 = new StringBuilder(br.readLine().trim()).reverse().toString();
        char[] N1Ary = N1.toCharArray();

        String N2 = br.readLine().trim();
        char[] N2Ary = N2.toCharArray();

        int T = Integer.parseInt(br.readLine().trim());
        if (T < N1Cnt) {
            for (int i = 0; i < N1Cnt - T; i++) {
                System.out.print(N1Ary[i]);
            }
        }

        int minT = Math.min(T, Math.min(N1Cnt, N2Cnt));
        for (int i = 0; i < minT; i++) {
            System.out.print(N2Ary[i]);
            if (N1Cnt - T + i >= 0) {
                System.out.print(N1Ary[ N1Cnt - T + i ]);
            }
        }
        if (T > N2Cnt) {
            for (int i = T - N1Cnt ; i >= 0; i--) {
                if (i <= N2Cnt) System.out.print(N1Ary[N1Cnt - i  - 1 ]);
            }
        }else{
            for (int i = T; i < N2Cnt; i++) {
                System.out.print(N2Ary[i]);
            }
        }
    }
}
