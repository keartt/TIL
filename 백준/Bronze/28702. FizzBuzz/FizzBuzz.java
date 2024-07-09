

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        int i = 1;
        for (int j = 0; j < 3; j++) {
            input = br.readLine();
            if (!input.equals("Fizz") && !input.equals("FizzBuzz") && !input.equals("Buzz")) {
                i = Integer.parseInt(input);
            }
            i++;
        }

        if (i % 3 == 0 || i % 5 == 0) {
            if (i % 3 != 0) {
                input = "Buzz";
            } else if (i % 5 != 0) {
                input = "Fizz";
            } else {
                input = "FizzBuzz";
            }
        }else{
            input = String.valueOf(i);
        }

        bw.write(input);

        bw.flush();
        bw.close();
    }

}
