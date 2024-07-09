
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int homeToSchool = Integer.parseInt(br.readLine());
        int schoolToPc = Integer.parseInt(br.readLine());
        int pcToAcademy = Integer.parseInt(br.readLine());
        int academyToHome = Integer.parseInt(br.readLine());

        int sum = homeToSchool + schoolToPc + pcToAcademy + academyToHome;
        int min = sum / 60;
        int sec = sum % 60;

        System.out.println(min);
        System.out.println(sec);
    }
}