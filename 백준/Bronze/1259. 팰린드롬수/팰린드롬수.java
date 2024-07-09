import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] split = br.readLine().split("");
            if (split.length ==1 && split[0].equals("0")) break;

            String answer = "yes";
            for (int i = 0; i < split.length / 2; i++) {
                if (!split[i].equals(split[split.length - 1 - i])) {
                    answer = "no";
                    break;
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}