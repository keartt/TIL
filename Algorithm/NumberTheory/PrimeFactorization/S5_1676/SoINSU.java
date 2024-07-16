package Algorithm.Algorithm.NumberTheory.PrimeFactorization.S5_1676;

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
        // 지금 10! 안에 소인수분해 값들이 몇개씩 있는지 적음
        bw.write("10! =\t");
        for (int j = 0; j < num + 1; j++) {
            if (arr[j] > 0) {
                bw.write(j + "^" + arr[j] +"\t");
            }
        }

        bw.flush();
        bw.close();
    }

    public BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
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

