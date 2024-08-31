import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int result = 0;
        int repeat = 0; // IOI 'IOI'OI 'IOIOI'OI ...

        for (int i = 1; i < M - 1; i++) {
            if (str[i - 1] == 'I' && str[i] == 'O' && str[i + 1] == 'I') {
                repeat++;
                if (repeat == N) {
                    result++;
                    // 찾고자 하는 횟수 찾았으므로 다시 첨부터 찾는다
                    repeat--;
                }
                // i+1 까지 찾고자하는거랑 맞으니까 다다음으로 넘어가야함
                i++;
            } else {
                repeat = 0;
            }
        }
        System.out.println(result);
    }

    // static void wrong() {
    //     int pSize = 2 * N + 1;
    //     StringBuilder p = new StringBuilder();
    //     for (int i = 0; i < pSize; i++) {
    //         p.append(i % 2 == 0 ? "I" : "O");
    //     }
    //     String Pn = String.valueOf(p);
    //     System.out.println(Pn);
    //
    //     int count = 0;
    //     for (int i = 0; i < M - pSize; i ++) {
    //         // 인덱스에서 찾고자하는 값이 있다면
    //         if (str.indexOf(Pn, i) > 0) {
    //             count++;
    //             // 찾았으므로 인덱스 증가시켜줘야 함
    //             i += pSize - 1;
    //         }
    //     }
    //     System.out.println(count);
    // }
}