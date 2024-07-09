
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        BigInteger big = new BigInteger(String.valueOf(1));
        for (int i=1; i<=num; i++) {
            big = big.multiply(BigInteger.valueOf(i));
        }
        String facNumString = String.valueOf(big);

        long zeroCount = 0;
        for (int i = facNumString.length() -1; i >=0; i--) {
            if (facNumString.charAt(i) == '0'){
                zeroCount++;
            }else{
                break;
            }
        }

        bw.write(zeroCount + "\n");
        bw.flush();
        bw.close();
    }
}