import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Work[] workList = new Work[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            workList[i] = new Work(time, pay);
        }
        //
        int[] dp = new int[N + 1];
        for (int day = 0; day < N; day++) {
            Work work = workList[day];
            // 지금 주어진 일을 기간 내에 수행할 수 있을 경우
            if (day + work.time <= N) {
                // 지금 주어진 work 를 수행했을때, 누적되는 금액
                int workNow = dp[day] + work.pay;
                // 원래 그 날짜에 누적될 예정인 금액
                int workOther = dp[day + work.time];
                // 해당 날짜에 최댓값을 넣어줌
                dp[day + work.time] = Math.max(workNow, workOther);
            }
            // 현재 날짜에 새로 시작한 일이 없을경우 다음날에는
            // 현재 날짜 값과 다음날의 원래 값 중 큰 값을 넣어줌
            dp[day + 1] = Math.max(dp[day], dp[day + 1]);
        }
        System.out.println(dp[N]);
    }

    static class Work {
        int time;
        int pay;

        public Work(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }
    }
}