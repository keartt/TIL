import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < 8; i++) {
            if (sum == 100) break;
            for (int j = i + 1; j < 9; j++) {
                // 2명 빼면 100일때
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    sum = 100; // 바깥 for 문 종료
                    break;
                }
            }
        }

        Arrays.sort(arr);
        for (int i : arr) {
            if (i != 0)  sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
