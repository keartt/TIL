package Algorithm.BinarySearch.S2_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(st2.nextToken());
            if (len > max) max = len;
            tree[i] = len;
        }
        int min = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            long getTree = 0;

            for (int i = 0; i < N; i++) {
                long get = tree[i] - mid;
                if (get > 0) getTree += get;
            }
            if (getTree >= M) {
                min = mid + 1;
            } else {
                max = mid -1;
            }

        }
        System.out.println(max);
    }
}
/*
설계
나무 길이에 대한 정보를 저장한다. 동시에 최대 크기를 구한다 (right)
left~right (0, max)를 시작으로 파라메트릭 서치를 시작한다.
H(mid)로 자르고 난 후 얻을 수 있는 나무의 총 길이를 tree라고 하자.
tree >= m 이면, 너무 많이 잘랐으므로 최솟값을 올려준다. left = mid+1;
        tree < m 이면, 나무가 부족하므로 최댓값을 내려준다. right = mid-1;
 */
