import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input1 = sc.nextInt();
        long input2 = sc.nextInt();
        System.out.println(Math.abs(input1 - input2));
    }
}
