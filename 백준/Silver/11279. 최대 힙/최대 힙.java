import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        // 큰 수가 먼저 나오는 우선순위 큐 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while (T--> 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append("0");
                } else {
                    sb.append(queue.remove());
                }
                sb.append("\n");
            }else{
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}
