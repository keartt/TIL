import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String msg = st.nextToken();
            for (char c : msg.toCharArray()) {
                System.out.print(String.valueOf(c).repeat(count));
            }
            System.out.println();
        }
    }
}