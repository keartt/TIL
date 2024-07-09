import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        char[] numArr = br.readLine().toCharArray();
        int sum = 0;
        for (char i : numArr) {
            sum += i - '0';
        }
        System.out.println(sum);

    }
}