
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int inputLen = input.length();

        int N = Integer.parseInt(input);
        int result = 0;
        for (int i = N - inputLen * 9; i < N; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0){
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N){
                result = i;
                break;
            }

        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
