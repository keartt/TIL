package Algorithm.DP._Fibonacci;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = -1;
        }
        arr[0] = 0;
        if (N > 1) arr[1] = 1;
        bw.write(fibonacci2(N) + "\n");

        bw.flush();
        bw.close();
    }

    // DP - 메모이제이션 (Top-down approach) 으로 피보나치 구현
    static long fibonacci2(int n) {
        if(arr[n] == -1)  {
            arr[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
        }
        return arr[n];
    }
}
