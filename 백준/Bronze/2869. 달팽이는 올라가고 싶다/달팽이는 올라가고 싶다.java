
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long up = Long.parseLong(st.nextToken());
        long down = Long.parseLong(st.nextToken());
        long height = Long.parseLong(st.nextToken());

        long day = (height - down) / (up - down);

        if ((height - down) % (up - down) != 0) {
            day++;
        }

        // time out
        /*
        long day = 1;
        long complete = up;
        while (complete < height) {
            complete -= down;

            day++;
            complete += up;
            if (complete >= height) break;
        }*/

        bw.write(day + "\n");
        bw.flush();
        bw.close();
    }
}

