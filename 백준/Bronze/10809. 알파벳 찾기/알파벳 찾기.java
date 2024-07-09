import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException {
        int alphabet[] = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        for (int i = 0; i < S.length; i++) {
            int ascii = (int) S[i] - 97;
            if (alphabet[ascii] == -1) alphabet[ascii] = i;
        }

        for (int i : alphabet) {
            System.out.println(i);
        }
    }
}
