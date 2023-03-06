package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 인구차이가 L ~ R이면 국경선을 연다 -> BFS로 열리는 나라 탐색
 * 2. 인구이동 시작한다
 * 3. 인구이동은 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
 * 3. 종료조건 -> 인구의 이동이 없을 때까지 지속된다.
 */
public class p16234 {
	
	static int[][] move = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };
	static int[][] map;
	static boolean[][] visited;
	static int n, l, r;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		l = Integer.parseInt(st.nextToken()); 
		r = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 열리는 나라 탐색
		int time = 0;
		while (true) {
			visited = new boolean[n][n];
			flag = false;
			// 인구의 이동 확인
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			if (flag) time++;
			else break;
		}
		System.out.println(time);
	}

	private static void bfs(int x, int y) {
		int[] start = new int[] {x, y};
		List<int[]> area = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			// 경계를 공유하는 나라들
			area.add(p);
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + move[i][0], ny = p[1] + move[i][1];
				
				if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
				if (visited[nx][ny]) continue;
				// 조건 -> L ~ R사이
				if (l <= diff(p, nx, ny) && diff(p, nx, ny) <= r) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		// 나라가 2개이상 열림
		if (1 < area.size()) {
			flag = true;
			int sum = 0;
			for (int[] p : area) {
				sum += map[p[0]][p[1]];
			}
			// 인구 나누기
			int average = sum / area.size();
			// 평균값으로 다시 세팅
			for (int[] p : area) {
				map[p[0]][p[1]] = average;
			}
		}
	}

	private static int diff(int[] p, int nx, int ny) {
		return Math.abs(map[nx][ny] - map[p[0]][p[1]]);
	}
}
