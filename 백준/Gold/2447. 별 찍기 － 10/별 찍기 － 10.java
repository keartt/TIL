import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        star = new char[N][N];

        solution(0, 0, N, false);
        
        //write
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // recur
    static void solution(int r, int c, int size, boolean blank) {
        // 탈출 조건 1.
        // 만약 비어있는 값을 가진다면 해당 구역(size) 만큼 모두 공백을 칠해줘야 함
        // 이렇게 하지 않으면 공백은 어떤 구역이던 한개만 들어감
        if (blank) {
            for (int i = r; i < r + size; i++) {
                for (int j = c; j < c + size; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        // 탈출 조건 2.
        // size 가 1이 될떄까지 나눈다.
        // 근데 이때 이 값이 blank 가 아니므로 * 을 채운다
        if (size == 1) {
            star[r][c] = '*';
            return;
        }

        // 3의 제곱근인 size 의 1/3 의 값을 새로운 size 로 갖고
        // 그 구역으로 반목문을 실행한다.
        int newsSize = size / 3;
        int count = 0;
        // 현재 들어온 row, col 값으로부터
        // 최대는 +size(원래 size)
        // 반복 시 늘어나는 값은 구역만큼 반복하기에 newSize
        for (int i = r; i < r + size; i += newsSize) {
            for (int j = c; j < c + size; j += newsSize) {
                count++;
                // 5번째는 공백임을 t/f 로 알려주고 재귀 실행
                solution(i, j, newsSize, count == 5);
            }
        }
    }
}