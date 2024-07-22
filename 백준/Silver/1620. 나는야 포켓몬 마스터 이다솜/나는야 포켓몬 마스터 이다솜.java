import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> names = new HashMap<>();
        Map<Integer, String> indexs = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            names.put(name, i);
            indexs.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            try {
                int num = Integer.parseInt(question);
                sb.append(indexs.get(num)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(names.get(question)).append("\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}

