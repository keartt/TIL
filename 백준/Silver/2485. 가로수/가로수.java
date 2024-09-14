import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int GCD = 0;
        for (int i = 0; i < N - 1; i++) {
            int dif = arr[i + 1] - arr[i];
            GCD = GCD(dif, GCD);
        }

        int count = 0;
        for (int i = arr[0]; i <= arr[N - 1]; i += GCD) {
            count++;
        }
        System.out.println(count - N);
    }

    static int GCD(int a, int b){
        return b != 0 ? GCD(b, a % b) : a;
    }
}