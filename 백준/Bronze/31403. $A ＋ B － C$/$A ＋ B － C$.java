import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int C = Integer.parseInt(br.readLine());

        int r1 = Integer.parseInt(A) + Integer.parseInt(B);
        int r2 = Integer.parseInt(A + B);
        System.out.println(r1 - C);
        System.out.println(r2 - C);
    }
}