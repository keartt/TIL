import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Block = Integer.parseInt(st.nextToken());

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now > maxH) maxH = now;
                if (now < minH) minH = now;
                arr[i][j] = now;
            }
        }

        // 접근
        // 전부 동일한 높이로 채우는것
        // -> 입력값 중 최소~ 최대 사이에만 목표가 존재함
        int resultHeight = 0;                    // 가능한 높이는 높은걸로
        int resultTime = Integer.MAX_VALUE;    // 최솟값 찾아야 함

        // 목표 높이 를 기준으로 반복
        for (int targetH = minH; targetH <= maxH; targetH++) {
            int runningTime = 0;
            int remainBlock = Block;

            for (int[] ar : arr) {
                // if (remainBlock < 0) break;
                // 이 for문 안에서 블록을 체크하면 안된다.
                // 우리는 배열을 순서대로 돌기때문에 음수면 안되지만
                // 문제 상황에서는 그냥 아무데서나 뺏다 넣엇다 하기에
                // 반복문 종료 후 아래에서 블록 음수체크 해야함
                for (int nowH : ar) {
                    if (nowH == targetH) continue;
                    // 목표높이와 지금 높의를 비교하고
                    // 그 차이값 만큼 time 과 block 수를 조정한다.
                    if (nowH > targetH) {
                        // 지금이 더 크니까 블록 제거하는거 - 2 초 소요
                        runningTime += (nowH - targetH) * 2;
                        remainBlock += (nowH - targetH);
                    } else {
                        runningTime += (targetH - nowH);
                        remainBlock -= (targetH - nowH);
                    }
                }
            }
            

            // continue 가 아니라 break 인 이유 = 시간초과
            // 컨티뉴를 하게 되면 다음으로 넘어간다 ( 더 큰 maxH 를 찾아서)
            // 근데 지금도 블락이 부족한데(-) 더 큰거는 무조건 부족하지 않아?
            // 그니까 break
            if (remainBlock < 0) break;

            // 시간이 더 작거나 **같으면**
            if (runningTime <= resultTime) {
                resultTime = runningTime;
                // 높이는 큰거
                resultHeight = Math.max(targetH, resultHeight);
            }
        }

        bw.write(resultTime + " " + resultHeight);
        bw.flush();
        bw.close();
    }


}

