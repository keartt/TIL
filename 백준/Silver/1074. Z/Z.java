import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        solution(0, 0, size, 0);
    }

    static int solution(int row, int col, int size, int lastValue) {
        // 찾고자 하는 (r, c) 좌표가 현재 사분면에 포함되면
        if (r >= row && c >= col &&
                r < row + size && c < col + size) {
            // 현재 구역을 4개의 사분면으로 나누어 각 사분면에 대해 재귀 호출
            size /= 2;
            lastValue = solution(row, col, size, lastValue); // left-top
            lastValue = solution(row, col + size, size, lastValue); // right-top
            lastValue = solution(row + size, col, size, lastValue); // left-bottom
            lastValue = solution(row + size, col + size, size, lastValue); // right-bottom
        } else {
            // 현재 사분면에 (r, c) 좌표가 포함되지 않으므로, 현재 사분면의 모든 셀 수를 순서에 더함
            lastValue += size * size;
        }

        // 현재 사분면의 시작점이 찾고자 하는 (r, c)와 일치하면, 현재까지의 순서 값을 출력하고 프로그램 종료
        if (row == r && col == c) {
            System.out.println(lastValue);
            // 종료를 해주지 않으면 이미 찾았는데 추가로 더 실행되기 때문
            System.exit(0);
        }
        return lastValue;
    }

}