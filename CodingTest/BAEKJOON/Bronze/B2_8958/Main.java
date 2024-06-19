package CodingTest.BAEKJOON.Bronze.B2_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int result = 0;
            int continuous = 1;
            for (char c : br.readLine().toCharArray()) {
                String answer = String.valueOf(c);
                if (answer.equals("O")){
                    result += continuous;
                    continuous++;
                }else{
                    continuous = 1;
                }
            }
            System.out.println(result);
        }
    }
}