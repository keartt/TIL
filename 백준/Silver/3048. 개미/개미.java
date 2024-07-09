import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n1Num;
	static int n2Num;
	static char[] group1;
	static char[] group2;
	static int time;

	public static void main(String[] args) throws Exception {

		// 그룹 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputValues = br.readLine();
		StringTokenizer st = new StringTokenizer(inputValues);
		n1Num = Integer.parseInt(st.nextToken());
		n2Num = Integer.parseInt(st.nextToken());

		// A그룹
		group1 = new char[n1Num];
		String g1 = br.readLine();
		group1 = g1.toCharArray();

		// B그룹
		group2 = new char[n2Num];
		String g2 = br.readLine();
		group2 = g2.toCharArray();

		// 시간
		String strTime = br.readLine();
		time = Integer.parseInt(strTime);

		// 하나의 배열에 넣기
		char[] arr = new char[n1Num + n2Num];
		for (int i = 0; i < n1Num; i++) {
			arr[n1Num - 1 - i] = group1[i];
		}
		for (int i = 0; i < n2Num; i++) {
			arr[n1Num + i] = group2[i];
		}

		// 시간만큼 반복
		for (int i = 0; i < time; i++) {

			// 교환 수
			int output;
			if (n1Num == 1) {
				output = n1Num;
			} else if ((i + 1) <= n1Num) {
				output = i + 1;
			} else {
				output = Math.abs(2 * n1Num - (i + 1));
			}

			int changeNum = 0;
			for (int j = 0; j < arr.length - 1; j++) {
				if (output == changeNum) {
					break;
				}
				if (check(arr[j], arr[j + 1])) {
					char temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					changeNum++;
					j++;
				}
			}
		}
		System.out.println(new String(arr));
	}

	// 교환해야 하는 인덱스인지 확인
	public static boolean check(char charA, char charB) {

		boolean checka = false;
		for (int i = 0; i < n1Num; i++) { // n번째인 charA값이 group1인지 확인
			if (group1[i] == charA) {
				checka = true;
				break;
			}
		}

		boolean checkb = false;
		for (int i = 0; i < n2Num; i++) { // n번째인 charB값이 group2인지 확인
			if (group2[i] == charB) {
				checkb = true;
				break;
			}
		}

		return checka && checkb; // charA가 a그룹이고 그 다음에 오는 값이 b그룹이면 true
	}
}