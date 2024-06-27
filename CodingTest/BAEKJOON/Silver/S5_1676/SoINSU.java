package CodingTest.BAEKJOON.Silver.S5_1676;

import java.io.*;
import java.math.BigInteger;

public class SoINSU {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        int [] arr = new int[num + 1];
        BigInteger big = new BigInteger(String.valueOf(1));

        for (int i=1; i<=num; i++) {
            big = big.multiply(BigInteger.valueOf(i));
            soInSu(i, arr);
        }
        for (int j = 0; j < num + 1; j++) {
            if (arr[j] > 0) {
                System.out.print(j + ":" + arr[j] +"\t");
            }
        }


        bw.flush();
        bw.close();
    }

    static void soInSu(int N, int[] arr){
        for(int i = 2; i <= N; i++) {
            while(N % i == 0) {
                arr[i]++;
                N /= i;
            }
        }
    }
}

