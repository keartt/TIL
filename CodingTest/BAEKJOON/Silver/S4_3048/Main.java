package CodingTest.BAEKJOON.Silver.S4_3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // firstLine Skip
        br.readLine();
        // 방향전환
        String N1 =  new StringBuilder(br.readLine().trim()).reverse().toString();
        String N2 = br.readLine();

        int T = Integer.parseInt(br.readLine());

        char[] NGroup = (N1 + N2).toCharArray();
        int NCount = N1.length() + N2.length();

        // 개미 방향나타내는 배열, -> 우방향일경우 true
        boolean[] direction = new boolean[NCount];
        for (int i = 0; i< N1.length(); i++){
            direction[i] = true;
        }

        if(T > NCount) T = NCount - 1;
        while (T-- > 0) {
            for (int i = 0; i < NCount - 1; i++) {
//                != 으로 하면 안됨
//                i == true 고 i+1 은 false 일때만 동작해야함
                if (direction[i] && !direction[i + 1]) {
                    char tempN = NGroup[i];
                    NGroup[i] = NGroup[i + 1];
                    NGroup[i + 1] = tempN;

                    direction[i] = !direction[i];
                    direction[i + 1] = !direction[i + 1];

                    // i와 i+1 을 둘다 바꿧으므로 index 는 +2 가 되어야 함
                    i++;
                }
            }
        }

        for (char n : NGroup) {
            System.out.print(n);
        }
    }
}
