import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] arr;
    static int [] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        cnt = new int[N];
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // index 는 0부터 시작하기에 -
            int s = Integer.parseInt(st.nextToken()) -1;
            int e = Integer.parseInt(st.nextToken()) -1;
            arr[s].add(e);
            arr[e].add(s);
        }

        int minUser = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int count = BFS(i);
            if (count < minCount) {
                minCount = count;
                minUser = i;
            }
        }
        System.out.println(minUser + 1);
    }

    static int BFS(int start) {
        int count = 0;
        Arrays.fill(cnt, -1); // -1 이면 방문하지 않은거임 -> visited = false
        cnt[start] = 0;
        
        // BFS 를 통해 start 부터 모든 노드까지의 방문 거리를 cnt 값에 넣어서 구함
        // 그리고 구한 cnt 를 모두 더하면 start 로부터 다른 노드들까지의 방문 거리의 총 합이 됨
        // 이 값을 리턴하고 최솟값을 찾음
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (Integer i : arr[now]) {
                if (cnt[i] == -1) {
                    cnt[i] = cnt[now] + 1;
                    count += cnt[i];
                    queue.add(i);
                }
            }
        }

        return count;
    }

}