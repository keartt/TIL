import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        long N = Long.parseLong(br.readLine());
        for (long i = 0; i < N; i++) {
            // int 로 했다가 런타임 폭탄맞음
            long num = Long.parseLong(br.readLine());
            // runtime error
            // input 값은 0부터 시작임
            if (num <= 2){
                sb.append(2).append("\n");
                continue;
            }
            while (!isPrime(num)){
                num++;
            }
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
    static boolean isPrime(long n){
        for (long j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}