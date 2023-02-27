package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로1 {
	
	static int[][] pos;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int testCase = Integer.parseInt(br.readLine());
			pos = new int[2][2];
			map = new int[16][16];
			visited = new boolean[16][16];
			for (int j = 0; j < 16; j++) {
				String[] input = br.readLine().split("");
				for (int k = 0; k < input.length; k++) {
					int value = Integer.parseInt(input[k]);
					map[j][k] = value;
					if (value == 2) {
						pos[0][0] = j;
						pos[0][1] = k;
					} else if (value == 3) {
						pos[1][0] = j;
						pos[1][1] = k;
					}
				}
			}
			System.out.printf("#%d %d\n", testCase, bfs(pos[0][0], pos[0][1]));
		}

	}

	private static int bfs(int i, int j) {
		boolean check = false;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == pos[1][0] && curr[1] == pos[1][1]) {
				check = true;
				break;
			}
			for (int k = 0; k < 4; k++) {
				int cx = curr[0] + dx[k];
				int cy = curr[1] + dy[k];
				if (!visited[cx][cy]) {
					if (map[cx][cy] == 0) {
						visited[cx][cy] = true;
						queue.offer(new int[] {cx, cy});						
					}
					if (map[cx][cy] == 3) {
						check = true;
						break;
					}
				}
			}
		}
		if (check) {
			return 1;
		} else {
			return 0;
		}
	}
}
