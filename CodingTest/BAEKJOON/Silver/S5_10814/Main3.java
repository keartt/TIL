package CodingTest.BAEKJOON.Silver.S5_10814;

import java.io.*;
import java.util.StringTokenizer;

public class Main3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder[] ageList = new StringBuilder[201];

        // 나이가 정해져있으므로 해당 나이순으로 자동으로 정렬될 수 있도록
        // 나이 배열을 만든다. 인덱스 값 = 나이가 될 수 있도록 201 까지 설정
        for (int i = 0; i < 201; i++) {
            ageList[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            // 나이=인덱스인 나이배열 값에 실제 출력을 위한 값을 append 한다
            ageList[age].append(age).append(' ').append(name).append('\n');
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder al : ageList) {
            // 출력을 위한 StringBuilder 만들고 거기에 StringBuilder 배열에 들어있는 값을 넣는다.
            // 빈 값들은 없으므로 자연스럽게 나이 index 순서에 따라 출력이 진행된다.
            sb.append(al);
        }
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solution();
        bw.flush();
        bw.close();
    }
}


