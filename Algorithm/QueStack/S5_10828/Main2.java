package Algorithm.QueStack.S5_10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input) {
                case "push":
                    s.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(s.isEmpty() ? -1 : s.pop());
                    break;
                case "size":
                    sb.append(s.size());
                    break;
                case "empty":
                    sb.append(s.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    sb.append(s.isEmpty() ? -1 : s.peek());
                    break;
            }
            if (!input.equals("push")) sb.append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

}
