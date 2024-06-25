package CodingTest.Algorithm.TwoPointer.S4_1940;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        int sum = 0;
        int count = 0;

        while (start < end){
            sum = arr[start] + arr[end];
            if (sum == M){
                count++;
                start++;
                end--;
            }else if (sum < M){
                start++;
            }else { //if (sum > M)
                end--;
            }
        }
        System.out.println(count);

    }
}
