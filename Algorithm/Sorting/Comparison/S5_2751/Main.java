package Algorithm.Sorting.Comparison.S5_2751;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 절댓값 기준 1,000,000 이하 정수
        boolean[] num = new boolean[2000001];
        for (int i = 0; i < N; i++) {
            // 배열의 index 는 0부터 시작하므로 + 1,000,000
            num[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        for (int i = 0; i < num.length; i++) {
            // 원본 숫자는 인덱스 - 1,000,000
            if (num[i]) bw.write((i - 1000000) + "\n");
        }
        bw.flush();
        bw.close();
    }
}