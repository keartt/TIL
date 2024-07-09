import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[2000001];
        for (int i = 0; i < N; i++) {
            num[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i]) bw.write((i - 1000000) + "\n");
        }
        bw.flush();
        bw.close();
    }
}