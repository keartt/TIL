import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // K + 1 이 아니라 100001 로 설정한 이유는, N 이 K 보다 더 뒤에 있을수도 있기 때문
    static int [] times = new int[100001];
    static boolean [] visited = new boolean[100001];
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // N == K 일 경우 0을 출력해야 하므로 BFS 수행하지 않음
        if (N != K) {
            BFS(N);
        }
        System.out.println(times[K]);
    }

    private static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (int i = 0; i < 3; i++) {
                int next = now;
                switch (i) {
                    case 0:
                        next += 1;
                        break;
                    case 1:
                        next -= 1;
                        break;
                    case 2:
                        next *= 2;
                        break;
                }

                // 찾고자 하는 값이라면 더이상 BFS 수행 없이 종료함
                if (next == K) {
                    times[K] = times[now] + 1;
                    return;
                }

                // 인덱스 범위를 초과할 경우 건너뜀
                if (next < 0 || next > 100000 ) continue;

                // BFS 는 항상 최단거리를 보장한다.
                if (!visited[next]) {
                    times[next] = times[now] + 1;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
