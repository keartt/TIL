import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Integer> resultList = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                resultList.add(i);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println(-1);
        }else{
            int result = 0;
            for (Integer i : resultList) {
                result += i;
            }
            System.out.println(result);
            System.out.println(resultList.get(0));
        }

    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}