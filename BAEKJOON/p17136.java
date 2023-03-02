package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17136 {
	
	static int[][] map;
	static boolean[][] visited;
	static int paperCount;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 1) {
					paperCount++;
				}
			}
		}
		// 색종이로 덮기
		if (paperCount == 0) {
			answer = 0;
		} else {
			dfs(0, 0, 0);
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
		
	}

	private static void dfs(int x, int y, int count) {
		// 이미 최소보다 더 많이 붙여야하면
		if (answer < count) {
			return;
		}
		// 끝까지 탐색
		if (x == 9 && y == 10) {
			answer = Math.min(answer, count);
			return;
		}
		
		if (y == 10) {
			dfs(x + 1, 0, count);
			return;
		}
		
		if (map[x][y] == 1) {
			// 색종이 붙이기
			for (int size = 5; 1 <= size; size--) {
				// 붙일 수 있을때
				if (checkSquare(x, y, size) && 1 <= paper[size]) {
					visitedCheck(x, y, size, 0);
					paper[size]--;
					dfs(x, y + 1, count + 1);
					paper[size]++;
					visitedCheck(x, y, size, 1);
				}
			}
		} else {
			// 왼쪽 이동
			dfs(x, y + 1, count);
		}
	}

	private static boolean checkSquare(int x, int y, int size) {
		boolean check = true;
		if (10 < x + size || 10 < y + size) {
			return false;
		}
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != 1) {
					check = false;
					break;
				}
			}
		}
		return check;
	}
	
	private static void visitedCheck(int x, int y, int size, int check) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = check;
			}
		}
	}
}
