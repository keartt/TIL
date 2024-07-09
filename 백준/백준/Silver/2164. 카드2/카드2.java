

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 1번이 맨 위에 있음
        // 맨 위 버리고, 그 다음 맨 위를 맨 밑으로
        // 맨 위에 있는것만 맨 밑으로 들어간다
        // 처음들어간게 처음 나온다 FIFO -> que
        // 하나 남을떄까지 반복
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.remove();
            q.add(q.remove());
        }
        bw.write(q.peek() + "\n");

        bw.flush();
        bw.close();
    }

}
