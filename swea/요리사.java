package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사 {
	
	static int[][] board;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			visited = new boolean[n];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			devide(0, n / 2);
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}

	private static void devide(int start, int count) {
		// 두 분류로 나누어 짐
		if (count == 0) {
			calculate();
			return;
		}
		for (int i = start; i < board.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				devide(i + 1, count - 1);
				visited[i] = false;
			}
		}
	}

	private static void calculate() {
		int A = 0;
		int B = 0;
		for (int i = 0; i < visited.length - 1; i++) {
			for (int j = i + 1; j < visited.length; j++) {
				if (visited[i] && visited[j]) {
					A += board[i][j] + board[j][i];
				}
				
				if (!visited[i] && !visited[j]) {
					B += board[i][j] + board[j][i];
				}
			}
		}
		answer = Math.min(answer, Math.abs(A - B));
	}
}
