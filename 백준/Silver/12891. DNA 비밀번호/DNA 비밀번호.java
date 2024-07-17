//g

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] chk;
    static int[] pw;
    static boolean isOk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        chk = new int[4];
        for (int i = 0; i < 4; i++) {
            chk[i] = Integer.parseInt(st.nextToken());
        }
        pw = new int[4];
        int result = 0;

        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }
        if (isOk) result++;

        // 슬라이딩 윈도우 시작
        for (int end = P; end < S; end++) {
            int start = end - P;
            add(arr[end]);
            remove(arr[start]);
            if (isOk) result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void add(char c) {
        switch (c) {
            case 'A':
                pw[0]++;
                break;
            case 'C':
                pw[1]++;
                break;
            case 'G':
                pw[2]++;
                break;
            case 'T':
                pw[3]++;
                break;
        }
        checkIsOk();
    }

    static void remove(char c) {
        switch (c) {
            case 'A':
                pw[0]--;
                break;
            case 'C':
                pw[1]--;
                break;
            case 'G':
                pw[2]--;
                break;
            case 'T':
                pw[3]--;
                break;
        }
        checkIsOk();
    }

    static void checkIsOk() {
        isOk = (pw[0] >= chk[0] && pw[1] >= chk[1] && pw[2] >= chk[2] && pw[3] >= chk[3]);
    }
}
