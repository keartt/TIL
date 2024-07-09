import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder[] ageList = new StringBuilder[201];

        for (int i = 0; i < 201; i++) {
            ageList[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            ageList[age].append(age).append(' ').append(name).append('\n');
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder al : ageList) {
            sb.append(al);
        }
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solution();
        bw.flush();
        bw.close();
    }
}


