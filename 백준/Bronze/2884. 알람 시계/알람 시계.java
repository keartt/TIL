import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int target = (H * 60 + M) - 45;
        if (target < 0) {
            target = 60 * 24 + target;
        }
        H = target / 60;
        M = target % 60;
        System.out.println(H + " " + M);
    }
}