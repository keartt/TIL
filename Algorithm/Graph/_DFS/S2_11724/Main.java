package Algorithm.Graph._DFS.S2_11724;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // node
        int M = Integer.parseInt(st.nextToken());   // edge

        visited = new boolean[N + 1];    // 방문여부 체크할 배열
        A = new ArrayList[N + 1];        // 그래프 데이터 저장 인접 리스트 (ArrayList 가 담겨있는 배열)
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        // 1. 인접 리스트 그래프에 데이터 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // start 시작점
            int e = Integer.parseInt(st.nextToken());   // end 종료점
            A[s].add(e);
            A[e].add(s);    // 문제에서 방향이 주어지지 않았기 때문에 종료-시작 도 설정해줌
        }

        int count = 0;  // 연결 노드 개수(정답)
        // 2. N 의 개수만큼 DFS 반복
        for (int i = 1; i < N + 1; i++) {
            // 방문하지 않은 노드가 있다면 연결 노드 개수 +1
            // 시작할 경우 아무것도 없었느데 시작했기 떄문에 +1
            // 이후에 DFS 함수를 재귀로 계속 돌리면서 방문한 노드들에 visited 를 True 로 바꾼 상태임
            // 이 상태에서 재귀 종료 후 확인해봤는데 false 라면 방문한 적 없다 = 서로 다른 연결노드이다
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    private static void DFS(int node) {
        // 이미 방문했다면 탐색 종료
        if (visited[node]) return;

        // 지금 노드는 방문한거임
        visited[node] = true;
        for (Integer i : A[node]) {
            // 연결된 인접 리스트에서 탐색하지 않는 노드가 있다면 DFS 재귀 
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}