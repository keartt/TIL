import java.util.*;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // step 1. 구간 합 배열 생성
        int[] S = new int[N];
        S[0] = arr[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + arr[i];
        }

        // step 2. K 만큼 구간합을 구하는 슬라이딩 윈도우 재현
        // 첫번째 구간합 0~K
        int max = S[K - 1]; // index 는 0부터 시작이므로 - 1
        
        // K-1 의 다음부터 최대 인덱스까지(<N)
        for (int i = K; i < N; i++) {
            // 구간합 = i 까지의 구간합 - 
            int sum = S[i] - S[i - K];
            //최댓값 구하기
            if (sum > max) max = sum;
        }
        
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
