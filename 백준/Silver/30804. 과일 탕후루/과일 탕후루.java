import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 인덱스 담는 배열, 몇번째에 무슨 과일인지
        int[] arr = new int[N];
        // 총 과일 개수 담는 배열 (과일 번호에 해당하는 인덱스++, 최대 9개이므로 세기 쉽게 9+1)
        int[] fruits = new int[10];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int nowFruitKind = 0; // 현재 과일 종류 개수
        while (end < N) {
            // 현재 end 인덱스에 해당하는 과일이 0개라면
            // 최초 input 이기때문에 종류를 1개 더한다
            // 더하면서 후위연산자로 과일개수 ++
            if (fruits[arr[end]]++ == 0) {
                nowFruitKind++;
            }

            // 과일종류가 2개를 넘으면 start 변화 시작
            while (nowFruitKind > 2) {
                // 현재 start 에 해당하는 과일 개수를 1개 줄임
                if (--fruits[arr[start]] == 0) {
                    // 만약 줄이니까 그 개수가 0개라면
                    // 과일이 없으므로 종류 -1
                    nowFruitKind--;
                }
                // 다음 start로
                start++;
            }

            // 현재 end 인덱스에서 조건을 만족하는 과일 개수
            int nowFruitCount = end - start + 1;

            // 와 이전 결과를 비교(최댓값 찾기)
            result = Math.max(result, nowFruitCount);
            // 다했으면 end 한칸 뒤로
            end++;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}