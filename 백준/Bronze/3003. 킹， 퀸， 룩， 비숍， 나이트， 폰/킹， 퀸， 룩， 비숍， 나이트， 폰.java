import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] origin = { 1, 1, 2, 2, 2, 8};

        String result = "";
        for (int i = 0; i< 6; i++){
            int input = sc.nextInt();
            result += origin[i] - input + " ";
        }
        System.out.println(result);
    }
}
