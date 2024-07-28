import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> priorityQ = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (priorityQ.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(priorityQ.remove()).append("\n");
                }
            }else{
                priorityQ.add(num);
            }
        }
        bw.write(sb.toString());


        bw.flush();
        bw.close();

    }
}