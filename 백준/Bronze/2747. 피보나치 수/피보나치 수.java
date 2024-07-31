import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long result = 1;
        long first = 0;
        long second = 1;
        for (int i = 1; i < N; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}