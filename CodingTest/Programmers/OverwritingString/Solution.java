package CodingTest.Programmers.OverwritingString;

public class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder answer = new StringBuilder(my_string);

        int ovrStrLen = overwrite_string.length();
        for (int i = 0; i < ovrStrLen; i++) {
            answer.setCharAt(s + i, overwrite_string.charAt(i));
        }

        return answer.toString();
    }
}
