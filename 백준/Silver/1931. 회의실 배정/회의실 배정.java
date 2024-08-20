import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(s, e);
        }
        Arrays.sort(arr);

        int result = 0;
        int lastEnd = 0;
        for (Meeting meeting : arr) {
            // 정렬된 회의를 순서대로 돌면서 시작시간을 찾고
            if (meeting.startTime >= lastEnd) {
                // 시작 시간이 이전 끝난 시간 이후라면 그 회의 진행 (result++)
                result++;
                // 진행했으면 이전 끝난 시간 업데이트
                lastEnd = meeting.endTime;
            }
        }

        System.out.println(result);
    }

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting input) {
            // 종료시간으로 먼저 정렬해야 가장 많은 회의를 진행할 수 있음
            if (input.endTime == this.endTime) {
                return this.startTime - input.startTime;
            }
            return this.endTime - input.endTime;
        }
    }
}
