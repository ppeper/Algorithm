package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {

	static int max;
	static int min;
	static int[] number;
	// 순서 (- +, -, x, %)
	static int[] op;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testCase = 1; testCase <= n; testCase++) {
			int N = Integer.parseInt(br.readLine());
			number = new int[N];
			op = new int[4];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			pickOper(N - 1, "");
			System.out.printf("#%d %d\n",testCase, max - min);
		}
	}

	private static void pickOper(int n, String oper) {
		if (n == 0) {
			calculate(oper);
			return;
		}
		for (int i = 0; i < op.length; i++) {
			if (op[i] != 0) {
				op[i]--;
				pickOper(n - 1, oper + i);
				op[i]++;
			}
		}
	}

	private static void calculate(String oper) {
		char[] opers = oper.toCharArray();
		int buffer = number[0];
		for (int i = 0; i < number.length - 1; i++) {
			int op = opers[i] - '0';
			if (op == 0) {
				buffer = buffer + number[i + 1];
			} else if (op == 1) {
				buffer = buffer - number[i + 1];
			} else if (op == 2) {
				buffer = buffer * number[i + 1];
			} else {
				buffer = buffer / number[i + 1];
			}
		}
		max = Math.max(max, buffer);
		min = Math.min(min, buffer);
	}
}