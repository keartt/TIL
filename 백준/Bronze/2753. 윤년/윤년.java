import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        if (T % 4 == 0 && T % 100 != 0 || T % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}