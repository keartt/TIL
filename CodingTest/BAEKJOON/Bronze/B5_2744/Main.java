package CodingTest.BAEKJOON.Bronze.B5_2744;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputText = sc.next();
        StringBuilder answer = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            }else{
                answer.append(Character.toLowerCase(c));
            }
        }
        System.out.println(answer);
    }
}