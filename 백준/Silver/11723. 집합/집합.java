import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int bitS = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken()) - 1;
            }

            switch (str) {
                case "add":
                    bitS |= (1 << num);
                    break;
                case "remove":
                    bitS &= ~(1 << num);
                    break;
                case "check":
                    int chk = bitS & (1 << num);
                    if (chk != 0) chk = 1;
                    sb.append(chk).append("\n");
                    break;
                case "toggle":
                    bitS ^= (1 << num);
                    break;
                case "all":
                    //bitS |= ~0;
                    bitS = (1 << 21) - 1;
                    break;
                case "empty":
                    bitS = 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}