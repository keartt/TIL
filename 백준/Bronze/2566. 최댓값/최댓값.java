import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int maxNum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > maxNum) {
                    maxNum = num;
                    row = i +1;
                    col = j +1;
                }
            }
        }
        bw.write(maxNum + "\n" + row + " " + col);
        bw.flush();
        bw.close();
    }
}