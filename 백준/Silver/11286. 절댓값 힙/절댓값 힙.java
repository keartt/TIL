import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<AbsAesc> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.remove().num).append("\n");
                }
            } else {
                pq.add(new AbsAesc(number));
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class AbsAesc implements Comparable<AbsAesc> {

        private int num;
        public AbsAesc(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(AbsAesc o) {
            int oriAbs = Math.abs(this.num);
            int inputAbs = Math.abs(o.num);
            if (oriAbs == inputAbs) {
                return this.num - o.num;
            }else{
               return oriAbs - inputAbs;
            }
        }
    }
}

