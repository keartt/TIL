
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result= 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) result++;
        }
        System.out.println(result);
    }
    static boolean isPrime(int num) {
        if (num < 2) return false;
        // 제곱근 double sqrt = Math.sqrt(num); 
        double sqrt = Math.sqrt(num);
        for (int i = 2; i  <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}