package CodingTest.BAEKJOON.Bronze.B1_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken().toUpperCase();
        int[] arr = new int[26];
        int max = -1;
        char str = '?';

        for (int i = 0; i < text.length(); i++) {
            int count = arr[text.charAt(i) - 65]++;
            if (max < count) {
                max = count;
                str = text.charAt(i);
            } else if (max == count) {
                str = '?';
            }
        }
        System.out.println(str);
    }
}
