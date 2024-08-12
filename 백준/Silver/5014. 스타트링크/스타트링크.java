import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] floors;
    static int F, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()) + 1;       // 총 층수
        floors = new int[F];
        visited = new boolean[F];

        int S = Integer.parseInt(st.nextToken());       // 현재 위치
        G = Integer.parseInt(st.nextToken());       // 가고자 하는 위치
        U = Integer.parseInt(st.nextToken());       // 올라갈 수 있는 크기
        D = Integer.parseInt(st.nextToken());       // 내려갈 수 있는 크기

        BFS(S);
        if (floors[G] == 0 && S != G) {
            System.out.println("use the stairs");
        } else {
            System.out.println(floors[G]);
        }
    }

    private static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int now = queue.remove();

            if (now == G) {
                break;
            }

            int up = now + U;
            if (up < F && !visited[up]) {
                floors[up] = floors[now] + 1;
                visited[up] = true;
                queue.add(up);
            }
            int down = now - D;
            if (down > 0 && !visited[down]) {
                floors[down] = floors[now] + 1;
                visited[down] = true;
                queue.add(down);
            }
        }
    }
}