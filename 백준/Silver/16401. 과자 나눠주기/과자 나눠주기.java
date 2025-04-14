import com.sun.source.doctree.SummaryTree;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            if (snacks[i] > max) {
                max = snacks[i];
            }
        }

        int left = 1;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;

            for (int snack : snacks) {
                count += snack / mid;
            }

            if (count >= M) {
                result = mid; // 가능한 길이 중 최대값을 저장
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}