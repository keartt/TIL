import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int priceA = Integer.parseInt(st.nextToken());
        int priceB = Integer.parseInt(st.nextToken());
        int priceHalf = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        // 둘 중 더 적은 개수를 기준으로
        int count1 = Math.min(X, Y);
        // 각각 살때랑 반반 2개 살때 중 싼 값으로 계산
        int bestPrice = Math.min(priceA + priceB, 2 * priceHalf);
        int price = bestPrice * count1;

        // 사고 남은것중에 더 사야하는 거 기준으로 
        int count2 = Math.max(X, Y) - count1;
        // 그 하나의 값과 반반 중 싼값으로 계싼해서
        int morePrice = Math.min((X > Y ? priceA : priceB), 2 * priceHalf);
        // 두 값을 더한다.
        price += morePrice * count2;
        System.out.println(price);

    }
}