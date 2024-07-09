
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number != 0){
                s.push(number);
            }else{
                s.pop();
            }
        }
        int answer = 0;
        for (int num : s) {
            answer += num;
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }
}

