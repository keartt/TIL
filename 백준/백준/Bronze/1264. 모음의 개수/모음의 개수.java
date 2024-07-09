import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine().toLowerCase();
            if (input.equals("#")){
                break;
            }
            int count = 0;
            for (char ch : input.toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
