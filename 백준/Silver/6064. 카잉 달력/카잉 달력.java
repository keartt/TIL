import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(solution1()).append("\n");
        }
        System.out.println(sb);
    }
    private static int solution1() {
        int result = -1;

        // 총 길이는 두 수의 최소공배수임
        int rcm = M * N / GCD(M, N);

        // 나머지가 0일때 처리 해줘야 함
        int multi = 1;
        // x 값을 기준으로 증가하며 찾는다, 동일한 x 가 다시 나오기 우해서는 +M
        for (int i = x; i <= rcm; i += M) {
            // 각 x,y 의 값은 현재 idx % N 값임
            int nowY = i % N;
            if (nowY == 0) {
                nowY = N * multi++;
            }
            if (nowY == y) {
                result = i;
                break;
            }
        }

        return result;
    }

    private static int solution2() {
        int result = -1;
        int rcm = M * N / GCD(M, N);

        // 나머지가 0일때 처리를 위해
        x--;
        y--;
        // x 값을 기준으로 증가하며 찾는다, 동일한 x 가 다시 나오기 우해서는 +M
        for (int i = x; i < rcm; i += M) {
            // 각 x,y 의 값은 현재 idx % N 값임
            int nowY = i % N;
            if (nowY == y) {
                // -1 햇기에 +1
                result = i + 1;
                break;
            };
        }
        return result;
    }

    static int GCD(int A, int B) {
        if (A % B == 0) {
            return B;
        }else{
            return GCD(B, A % B);
        }
    }


    private static int timeOut() {
        int result = -1;

        // 총 길이는 두 수의 최소공배수임
        int rcm = M * N / GCD(M, N);

        int sumX = 1;
        int sumY = 1;

        for (int i = 1; i <= rcm; i++) {
            if (sumX > M) sumX = 1;
            if (sumY > N) sumY = 1;

            if (sumX == x && sumY == y) {
                result = i;
            }

            sumX++;
            sumY++;
        }
        return result;
    }
}