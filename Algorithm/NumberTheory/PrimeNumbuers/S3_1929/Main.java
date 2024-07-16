package Algorithm.Algorithm.NumberTheory.PrimeNumbuers.S3_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        whatPrimeInIndex(start, end);
    }

    static void whatPrimeInIndex(int start, int end) {
        boolean[] notPrime = new boolean[end + 1];
        if (start < 2 ) start = 2;
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (notPrime[i]) continue;
            for (int j = i * i; j <= end; j += i) {
                notPrime[j] = true;
            }
        }
        for (int i = start; i < end + 1; i++) {
            if (!notPrime[i]) System.out.println(i);
        }
    }
}
