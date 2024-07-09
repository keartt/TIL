import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        boolean notPirme[] = new boolean[N + 1];
        // false 면 소수임

        for (int i = 2; i * i < N + 1; i++) {
            if (notPirme[i]) continue;
            for (int j = i * i; j < N + 1; j += i) {
                notPirme[j] = true;
            }
        }
        if (M<2) M = 2;
        for (int i = M; i < notPirme.length ; i++) {
            if (!notPirme[i]) bw.write(i + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        bw.flush();
        bw.close();
    }
}
