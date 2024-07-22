import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) hashSet.add(br.readLine());

        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (hashSet.contains(name)) {
                count++;
                result.add(name);
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        sb.append(count).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

