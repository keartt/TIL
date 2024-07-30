import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        // 최솟값을 만들고 싶다 = 가장 큰걸 빼면 됨
        // 빼기를 기준으로 나누고 나머지들을 다 더하면 되지 않으까
        // 30-70-20+40-10+100+30-35
        // 30-70-(20+40)-(10+100+30)-35
        String[] forSum = str.split("-");
        int[] sumResult = new int[forSum.length];
        for (int i = 0; i < forSum.length; i++) {
            int sum = 0;
            String[] nums = forSum[i].split("\\+");
            for (String num : nums) {
                sum += Integer.parseInt(num);
            }
            sumResult[i] = sum;
        }
        int result = sumResult[0];
        for (int i = 1; i < sumResult.length; i++) {
            result -= sumResult[i];
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}

