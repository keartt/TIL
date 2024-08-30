import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] func = br.readLine().toCharArray();

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            String inputArr = br.readLine();
            inputArr = inputArr.substring(1, inputArr.length() - 1);

            String[] input = inputArr.split(",");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i : arr) {
                deque.add(i);
            }
            // R 여부 확인하기 위한 변수
            boolean asc = true;
            boolean err = false;
            for (char c : func) {
                if (c == 'R') {
                    asc = !asc;
                }else if (c == 'D'){ // 'D'
                    if (deque.isEmpty()) {
                        err = true;
                        break;
                    }
                    if (asc) {
                        deque.removeFirst();
                    }else{
                        deque.removeLast();
                    }
                }
            }
            // 출력
            if (err) {
                sb.append("error").append("\n");
            }else{
                // 함수 구하고 난 뒤의 디큐 크기
                int resultSize = deque.size();

                sb.append("[");
                for (int i = 0; i < resultSize; i++) {
                    if (asc) {
                        sb.append(deque.removeFirst());
                    } else {
                        sb.append(deque.removeLast());
                    }
                    // 마지막 값 빼고 , 추가
                    if (i != resultSize- 1 ) sb.append(",");
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}