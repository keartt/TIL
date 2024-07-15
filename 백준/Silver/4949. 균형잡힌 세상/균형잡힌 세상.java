

import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;
        Stack<Character> stack = new Stack<>();
        // 반례
        // ( [ ) ]  : 두 괄호가 요상하게 겹쳐있을 때

        while (true) {
            line = br.readLine();
            if (line.equals(".")) break;
            stack.clear();

            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.add(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.add(c);
                        break;
                    } else {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else{
                            break;
                        }
                    }
                }
                else if (c == ']') {
                    if (stack.isEmpty()) {
                        stack.add(c);
                        break;
                    } else {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else{
                            break;
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}