package CodingTest.Algorithm.NumberTheory.EuclideanGCD.B1_2609;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int GCD = GCD(a, b);

        bw.write(GCD + "\n");
        bw.write( (a * b / GCD) + "\n");

        bw.flush();
        bw.close();
    }

    static int GCD(int a, int b) {
        return b != 0 ? GCD(b, a % b) : a;
    }
}

