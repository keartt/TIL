import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arrayList);
        for (int i : arrayList) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}