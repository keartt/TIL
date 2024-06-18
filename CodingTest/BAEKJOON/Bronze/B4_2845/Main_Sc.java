package CodingTest.BAEKJOON.Bronze.B4_2845;

import java.util.Scanner;

public class Main_Sc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int p = sc.nextInt();
        int myData = l * p;

        for (int i = 0; i < 5; i++) {
            int value = sc.nextInt();
            System.out.print(value - myData + " ");
        }
        sc.close();
    }
}