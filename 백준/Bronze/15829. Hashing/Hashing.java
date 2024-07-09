
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigInteger sum = new BigInteger("0");
        BigInteger r = new BigInteger("31");
        BigInteger power = new BigInteger("1");

        for(int i=0; i<l; i++) {
            sum = sum.add(new BigInteger(String.valueOf(str.charAt(i)-'a' + 1)).multiply(power));
            power = power.multiply(r);
        }
        sum = sum.mod(new BigInteger("1234567891"));
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
