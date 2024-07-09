

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Solution(Integer.parseInt(br.readLine()));

        bw.write(result + "\n");
        bw.flush();
        bw.close();
   }

    static int Solution(int N) {
        int count = 0;

        if (N % 5 ==0) {
            count = N/5;
            return count;
        }else{
            int num = N;
            while (num > 0) {
                num -= 3;
                count++;
                if (num % 5 == 0){
                    count += num / 5;
                    return count;
                }
            }
        }
        return -1;
    }
}
