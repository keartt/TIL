import java.io.*;
import java.util.*;

public class Main {
    static boolean [] visited;
    static ArrayList<Integer> [] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int node = Integer.parseInt(br.readLine()); // computer
        int edge = Integer.parseInt(br.readLine()); // connection

        visited = new boolean[node];
        A = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            A[s].add(e);
            A[e].add(s);
        }

//        BFS(0);
        DFS(0);

        // 시작 노드로 부터 연결된 노드의 개수, visited 배열의 true 개수를출력하는 문제다!
        int result = 0;
        for (boolean v : visited) {
            if (v) result++;
        }
        // 시작노드로 부터 감염된 개수이므로 본인은 제외
        System.out.println(result - 1);
    }

    static void DFS(int node) {
        // 방문했으면 나가라
        if (visited[node]) return;
        visited[node] = true;
        for (Integer i : A[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (Integer i : A[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}