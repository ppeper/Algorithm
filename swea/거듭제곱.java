package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거듭제곱 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int test = Integer.parseInt(br.readLine());
			answer = 1;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			recursion(1, n, m);
			System.out.printf("#%d %d\n", test, answer);
		}
		
	}

	private static void recursion(int value, int n, int m) {
		if (m == 0) {
			answer = value;
			return;
		}
		recursion(value * n, n, m - 1);
	}
}
