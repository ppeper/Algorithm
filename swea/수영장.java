package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {

	static int[] price;
	static int[] plan;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= n; testCase++) {
			plan = new int[13];
			price = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			// 가장 크게 나올 수 있는 값은 1년이용권을 사용하였을때
			answer = price[3];
			search(1, 0);
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}

	private static void search(int i, int sum) {
		// 모든 달을 확인함
		if (13 <= i) {
			answer = Math.min(answer, sum);
			return;
		} 
		// 1일 이용권 사용
		search(i + 1, sum + price[0] * plan[i]);
		// 한 달권 사용
		search(i + 1, sum + price[1]);
		// 3달권 사용
		search(i + 3, sum + price[2]);
	}
}