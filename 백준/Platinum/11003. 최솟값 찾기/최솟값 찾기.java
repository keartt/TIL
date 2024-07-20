import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int NumLength = Integer.parseInt(st.nextToken());
        int slideSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<NumIndex> dq = new LinkedList<>();

        for (int i = 0; i < NumLength; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().getNum() > num) {
                dq.removeLast();
            }

            dq.addLast(new NumIndex(num, i));

            if (dq.getFirst().getIndex() == i - slideSize) {
                dq.removeFirst();

            }
            bw.write(dq.getFirst().getNum() + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class NumIndex {
        int num;
        int index;

        public NumIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }

        public int getNum() {
            return num;
        }

        public int getIndex() {
            return index;
        }
    }
  }

