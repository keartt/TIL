import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();

        int index = 0;
        int number = 1;
        while (index < N) {
            if (!s.isEmpty() && s.peek() == arr[index]) {
                s.pop();
                sb.append("-\n");
                index++;
            } else{
                s.add(number);
                sb.append("+\n");
                number++;
            }

            // add 후에는 ++ 가 진행됐기 때문에
            if (number -1 > N) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}