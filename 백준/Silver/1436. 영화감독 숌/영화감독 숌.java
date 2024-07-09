

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int number = 666;

        while (count != N) {
            number++;
            if (String.valueOf(number).contains("666")){
                count++;
            };
        }

        bw.write(number + "\n");
        bw.flush();
        bw.close();
    }
}
