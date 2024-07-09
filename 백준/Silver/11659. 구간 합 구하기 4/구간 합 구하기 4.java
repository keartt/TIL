
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] S = new int[N];
        S[0] = Integer.parseInt(st2.nextToken());
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken()) - 1;
            int end = Integer.parseInt(st3.nextToken()) - 1;

            if (start == 0) bw.write(S[end]+"\n");
            else bw.write(S[end] - S[start-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

