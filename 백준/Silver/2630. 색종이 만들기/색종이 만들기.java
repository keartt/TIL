import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int [][] paper;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 2 의 제곱근
        paper = new int[N][N];
        // 입력값 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        folding(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    // 재귀반복, 접기함수
    static void folding(int startRow, int startCol, int size) {

        // 현재 사분면이 모두 같은색이라면?
        if (colorChk(startRow, startCol, size)) {
            // 같은 색이면 이게 무슨색인지 확인해야겠지?
            if (paper[startRow][startCol] == 0) {
                white++;
            } else {
                blue++;
            }
            // 접기 안하고 종료
            return;
        }

        // 새로운 사이즈로 4개로 접고 각 사분면에 대해서 다시 접기 실행
        size /= 2;
        folding(startRow, startCol, size); // left-top
        folding(startRow, startCol + size, size); // right-top
        folding(startRow + size, startCol, size); // left-bottom
        folding(startRow + size, startCol + size, size); // right-bottom
    }

    // is same all color?
    static boolean colorChk(int startRow, int startCol, int size) {
        int color = paper[startRow][startCol];

        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                // 하나라도 색상이 다르다
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        // 모두 같다
        return true;
    }
}