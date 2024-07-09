import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        for (int i = 1; i < index + 1 ; i ++){
            int j = index - i;
            System.out.println(" ".repeat(j) + "*".repeat(i));
        }
    }
}
