import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scores = new int[N];
        int topScore = 0;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            if (topScore < score) topScore = score;
        }

        double newAvg = 0;
        for (int i : scores) {
            newAvg += ((double) i / topScore * 100);
        }
        System.out.println(newAvg/N);
    }
}