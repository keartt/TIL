package CodingTest.BAEKJOON.Bronze.B2_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result= 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num != 1) result++;
            for (int i = num - 1; i > 1; i--) {
                if (num % i == 0) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
