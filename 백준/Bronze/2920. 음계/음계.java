import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int asc = 0;
        int des = 0;

        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == i) asc++;
            if (num == 9 - i) des++;
        }
        if (asc == 8) System.out.println("ascending");
        else if(des ==8) System.out.println("descending");
        else System.out.println("mixed");
    }
}