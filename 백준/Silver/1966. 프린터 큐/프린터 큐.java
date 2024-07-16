import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<int[]> queue = new LinkedList<>();
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            queue.clear();
            for (int i = 0; i < N; i++) {
                // { 초기순서, 중요도 }
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            // 숫자가 하나만 들어왔다면 N == 1 : 1 출력
            sb.append(N > 1 ? solution(M, queue) : 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solution(int M, Queue<int[]> q) {
        int order = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            // 우선순위 높은거 비교할 변수
            boolean isMax = true;

            for (int[] arr : q) {
                // 다음 큐의 우선순위가 지금꺼보다 높으면 지금꺼 다시 add 하고 for 문 종료
                if (current[1] < arr[1]) {
                    q.add(current);
                    // 최대 우선순위 아님
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                // 최대면 다시 add 하지 않고 나간 순서 값 ++
                order++;
                // 만약 나간게 찾는 index M 과 같다면 종료
                if (current[0] == M) return order;
            }
        }
        return order;
    }
}