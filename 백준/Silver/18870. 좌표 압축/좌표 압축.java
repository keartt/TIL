import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        // 단순 정렬문제 ! 하지만 정렬되기 전 순서에 맞게 값을 출력해야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] origin = new int[T];
        int[] arr = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            origin[i] = num;
        }

        // 정렬된 값에 해당하는 순서를 넣어줄 Map
        Arrays.sort(arr);
        Map<Integer, Integer> sortMap = new HashMap<>();

        // 현재순서
        int rank = 0;
        for (int i : arr) {
            // ! 값이 이미 들어가있다면 넘어가야 함
            if (sortMap.containsKey(i)) continue;

            // 출력을 위한 Map 에 정렬된 i 순서대로 key 를 넣고
            sortMap.putIfAbsent(i, rank);
            // rank 를 넣은 후 다음 for 문을 위해 rank 증가
            rank++;
        }

        // 원본 배열 순서에 맞춰서 Map 의 값 빼서 출력
        StringBuilder sb = new StringBuilder();
        for (int i : origin) {
            sb.append(sortMap.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
