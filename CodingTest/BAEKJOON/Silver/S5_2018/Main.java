package CodingTest.BAEKJOON.Silver.S5_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        // 각 로직은 순서가 중요함
        while (end < N) {
            if (sum <= N) {
                if (sum == N) {
//                    System.out.println(start+","+end);
                    count++;
                }
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        // N 그 자체는 제외하나 결과에는 포함시키기에 초기 count + 1;
        System.out.println(++count);
    }
}
