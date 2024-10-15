class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];

        int x = 0;
        int y = 0;
        int now = 0;  // 방향 인덱스

        for (int i = 1; i <= n * n; i++) {
            // 현재 위치에 값을 넣고 방문 표시
            answer[x][y] = i;
            visited[x][y] = true;

            // 다음 위치 계산
            int nextX = x + direction[now][0];
            int nextY = y + direction[now][1];

            // 경계 또는 이미 방문한 곳일 경우 방향 변경
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                now = (now + 1) % 4;  // 방향 전환
                nextX = x + direction[now][0];
                nextY = y + direction[now][1];
            }

            // 다음 위치로 이동
            x = nextX;
            y = nextY;
        }

        return answer;
    }
}
