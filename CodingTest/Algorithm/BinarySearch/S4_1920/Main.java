package CodingTest.Algorithm.BinarySearch.S4_1920;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(solution(num)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solution(int num){
        int result = 0;

        int min = 0;
        int max = arr.length - 1;

        while (min <= max){
            int mid = (min + max) / 2;
            if (num == arr[mid]){
                result = 1;
                break;
            } else if (num > arr[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return result;
    }
}