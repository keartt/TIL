
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[arr.length -1 - i]) {
                result = 1;
            }else{
                result = 0;
                break;
            }
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}

