import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static ArrayList<Integer> [] A;
    static boolean visited [];
    static int node, edge, start;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        A = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            A[i] = new ArrayList<>();
        }

        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향 이므로 둘 다 넣어줌
            A[s].add(e);
            A[e].add(s);
        }
        // *문제조건* 여러개의 정점인 경우 번호가 작은거 먼저 방문
        for (int i = 1; i <= node; i++) {
            Collections.sort(A[i]);
        }
        // *주의* 아래처럼 짜면 오류남
        // A 배열 안에는 숫자가 아닌 ArrayList 가 있는데 이걸 어떻게 정렬할건데? 
        // Arrays.sort(A);

        visited = new boolean[node + 1];
        sb = new StringBuilder();
        DFS(start);
        System.out.println(sb);

        // 새로 시작하기에 초기화
        visited = new boolean[node + 1];
        sb = new StringBuilder();
        BFS(start);
        System.out.println(sb);
    }

    static void DFS(int now) {
        // 시작시 visited 체크를 하지 않는 이유는
        // 최초 DBF 진입은 시작점이기에 할 필요 없고
        // 나머지 DFS 진입은 아래 for 문에서 체크된것만 들어오기 때문임
        visited[now] = true;
        sb.append(now).append(" ");
        for (Integer i : A[now]) {
            // 방문했으면 나가라
            if (visited[i]) continue;
            // 다시 돌자
            DFS(i);
        }
    }

    static void BFS(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        // 현재 노드 방문 처리
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            // 큐 돌앗으니까 -> 빠져나왔으니 출력
            sb.append(now).append(" ");
            for (Integer i : A[now]) {
                // 방문했으면 나가라
                if (visited[i]) continue;

                // 원래 BFS 이므로 아래거 해줘야 함, 이번 문제에서는 필요없음
                // A[i] = now + 1
                visited[i] = true;
                queue.add(i);
            }
        }
    }
}

