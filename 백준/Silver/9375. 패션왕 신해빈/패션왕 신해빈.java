import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            // 옷의 종류의 개수만 세면 됨
            Map<String, Integer> map =new HashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken(); // 이름 필요 없음
                String type = st.nextToken();
                map.merge(type, 1, Integer::sum);
            }

            int result = 1;
            for (Integer value : map.values()) {
                // 안경은 벗고 모자는 쓰는 경우도 있으므로 벗는경우까지 생각해 +1
                // 조합공식 nC1 * nC1 ...
                result *= (value + 1);
            }
            // 저부 다 벗는건 안된다 했으므로 -1
            sb.append(--result).append("\n");
        }

        System.out.println(sb);
    }
}