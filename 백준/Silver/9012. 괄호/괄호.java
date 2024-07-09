
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write(solution(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static String solution(String input) {
        char[] arr = input.toCharArray();
        Stack<Character> s = new Stack<>();
        for (char a : arr) {
            if (a == '(') {
                s.add(a);
            }else{
                if (s.isEmpty()) return "NO";
                s.pop();
            }
        }
        return s.isEmpty() ? "YES" : "NO";
    }
}
