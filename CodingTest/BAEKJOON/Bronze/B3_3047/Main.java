package CodingTest.BAEKJOON.Bronze.B3_3047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int tokenCnt = st1.countTokens();
        int[] inputArr = new int[tokenCnt];
        for (int i = 0; i < tokenCnt; i++) {
            inputArr[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(inputArr);

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String order = st2.nextToken();
        for (char c : order.toCharArray()) {
            int a = 0;
            if (c == 'A') a = 0;
            if (c == 'B') a = 1;
            if (c == 'C') a = 2;
            System.out.print(inputArr[a] + " ");
        }
    }
}
