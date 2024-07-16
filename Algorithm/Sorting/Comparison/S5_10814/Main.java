package Algorithm.Sorting.Comparison.S5_10814;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[][] arrs = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrs[i][0] = st.nextToken();
            arrs[i][1] = st.nextToken();
        }

        Arrays.sort(arrs, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        for (String[] a : arrs) {
            bw.write(a[0] + " " + a[1] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        bw.flush();
        bw.close();
    }
}


