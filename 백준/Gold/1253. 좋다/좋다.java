import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        // 투 포인터는 항상 정렬될 필요는 없으나 본 문제에서는 정렬이 필요함
        // 반례 6 / 5 1 3 4 2 6
        Arrays.sort(arr);

        int result = 0;

        for (int k = 0; k < N; k++) {
            long K = arr[k];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                long sum = arr[start] + arr[end];
                if (K == sum) {
                    if (k == start){
                        start++;
                    } else if (k == end) {
                        end--;
                    } else {
                        result++;
                        break;
                    }
                } else if (K < sum) {
                    end--;
                } else { // K > sum
                    start++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}