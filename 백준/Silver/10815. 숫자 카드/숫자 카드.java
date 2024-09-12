import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Boolean> card = new HashMap<>();
        for (int i = 0; i < N; i++) {
            card.put(Integer.parseInt(st.nextToken()), true);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (card.containsKey(num)) {
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }



}