package Algorithm.Implements.S4_3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 개미 그룹의 개수 입력
        int n1 = Integer.parseInt(st.nextToken()); // 첫 번째 개미 그룹 개수
        int n2 = Integer.parseInt(st.nextToken()); // 두 번째 개미 그룹 개수

        int t; // 시뮬레이션 진행 시간
        int i = 0, j = 0;

        // 개미 그룹 입력
        String[] ant = new String[2]; // 두 개의 개미 그룹을 저장할 배열
        while (i < 2) {
            ant[i] = br.readLine(); // 개미 그룹 문자열 입력
            i++;
        }

        t = Integer.parseInt(br.readLine()); // 시뮬레이션 진행 시간 입력

        // t가 n1 + n2 - 1 이상인 경우 개미의 순서는 똑같기 때문에 t를 n1 + n2 - 1로 설정
        if (t > n1 + n2) {
            t = n1 + n2 - 1;
        }

        // 첫 번째 개미 그룹(ant[0]) 문자열을 뒤집기
        StringBuilder sb0 = new StringBuilder(ant[0]); // StringBuilder를 사용하여 문자열 뒤집기
        ant[0] = sb0.reverse().append(ant[1]).toString(); // 뒤집은 첫 번째 그룹과 두 번째 그룹을 합치기
        char[] ants = ant[0].toCharArray(); // 문자열을 문자 배열로 변환
        boolean[] check = new boolean[n1 + n2]; // 개미의 방향을 나타내는 배열

        // 첫 번째 개미 그룹은 true, 두 번째 개미 그룹은 false로 설정
        for (i = 0; i < n1; i++)
            check[i] = true;
        for (; i < n1 + n2; i++)
            check[i] = false;

        // 시뮬레이션 진행
        while (t-- > 0) {
            // 개미들을 순회하면서 인접한 개미의 위치와 방향을 교환
            for (i = 0; i < n1 + n2 - 1; i++) {
                if (check[i] && !check[i + 1]) {
                    // 개미의 위치 swap
                    char tmp = ants[i];
                    ants[i] = ants[i + 1];
                    ants[i + 1] = tmp;
                    // 방향도 swap
                    boolean tmp2 = check[i];
                    check[i] = check[i + 1];
                    check[i + 1] = tmp2;

                    i++; // 다음 개미는 이미 움직였으므로 한 칸 더 넘어감
                }
            }
        }

        // 최종적으로 개미들의 위치를 출력
        for (char ch : ants) {
            System.out.print(ch);
        }
        System.out.println(); // 개행 추가
    }
}
