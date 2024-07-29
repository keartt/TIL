import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap;
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                String symbol = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (symbol.equals("I")) {
                    // 현재 숫자에 해당하는 key 에 값을  +1 해준다 (없다면 0 +1)
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else { // D
                    if (!treeMap.isEmpty()) {
                        int value = num == 1 ? treeMap.lastKey() : treeMap.firstKey();
                        //map 에서 put 을 하면, 이전 key 의 값을 반환한다(없다면 null)
                        if (treeMap.put(value, treeMap.get(value) - 1) == 1)     // 이전 값이 1이었다면? 지금은 0 이겠지?
                            treeMap.remove(value);
                    }
                }
            }
            if (treeMap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                int min = treeMap.firstKey();
                int max = treeMap.lastKey();
                sb.append(max).append(" ").append(min);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}

