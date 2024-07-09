import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        double sqrt = Math.sqrt(N);
        for(int i = 2; i <= sqrt; i++){
            while(N % i == 0) {
                bw.write(i + "\n");
                N /= i;
            }
        }
        if(N!= 1) bw.write(N + "\n");
        
        bw.flush();
        bw.close();
    }
}