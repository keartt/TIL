
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    q.add(last);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1);
                    }else{
                        sb.append(q.poll());
                    }
                    break;
                case "size":
                    sb.append(q.size());
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1);
                    }else{
                        sb.append(q.peek());
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1);
                    }else{
//                        int qsize = q.size();
//                        for (int j = 0; j < qsize - 1; j++) {
//                            q.add(q.remove());
//                        }
//                        int last = q.poll();
//                        q.add(last);
                        sb.append(last);
                    }
                    break;
            }
            if (!input.equals("push")) sb.append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

}
