package CodingTest.BAEKJOON.Silver.S5_1181;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static void Solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });
        sb.append(arr[0]).append("\n");
        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i-1])){
                sb.append(arr[i]).append("\n");
            }
        }

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Solution();
        bw.flush();
        bw.close();
    }
}

