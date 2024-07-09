
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a * b * c;

        String sumString = String.valueOf(sum);

        int[] result = new int[10];
        for (char i : sumString.toCharArray()) {
            int num = i - '0';
            result[num] = ++result[num];
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}