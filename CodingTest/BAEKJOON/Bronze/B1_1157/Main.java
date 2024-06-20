package CodingTest.BAEKJOON.Bronze.B1_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();
        char[] alphabet = input.toCharArray();

        Map<String, Integer> result = new HashMap<>();
        for (char c : alphabet) {
            String cs = String.valueOf(c);
            result.put(cs, result.getOrDefault(cs, 0) + 1);
        }
        String maxAlphabet = "?";
        int maxCount = 0;
        for( Map.Entry<String, Integer> elem : result.entrySet() ){
            if (elem.getValue() > maxCount){
                maxAlphabet = elem.getKey();
                maxCount = elem.getValue();
            } else if (elem.getValue() == maxCount) {
                maxAlphabet = "?";
            }
        }
        System.out.println(maxAlphabet);
    }
}
