package CodingTest.BAEKJOON.Bronze.Bronze2442;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for (int i = 1; i <= cnt; i++) {
            String empty = " ".repeat(cnt - i);
            String star = "*".repeat(2 * i - 1);
            System.out.println(empty + star);
        }

    }
}