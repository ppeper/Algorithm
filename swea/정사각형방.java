package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 가장 거리를 많이 이동해야하고, 그런 방이 많으면 가장 작은 방.
 */
public class 정사각형방 {
	
	static class Point implements Comparable<Point> {
		int pos, dist;

		public Point(int pos, int dist) {
			this.pos = pos;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			if (this.dist == o.dist) {
				return this.pos - o.pos;
			}
			return o.dist - this.dist;
		}
		
	}
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static PriorityQueue<Point> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			answer = new PriorityQueue<Point>();
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = true;
					dfs(i, j, 1, map[i][j]);
					visited[i][j] = false;
				}
			}
			int count = 1;
			Point p = answer.poll();
			int value = p.pos;
			int max = p.dist;
			while (!answer.isEmpty()) {
				if (max == answer.poll().dist) {
					count++;
				} else {
					break;
				}
			}
			System.out.printf("#%d %d %d\n", testCase, value, max);
		}
	}

	private static void dfs(int x, int y, int distance, int pos) {
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (0 <= cx && cx < map.length && 0 <= cy && cy < map.length) {
				// 1칸만 작을때 이동가능
				if (!visited[cx][cy] && map[cx][cy] == map[x][y] + 1) {
					visited[cx][cy] = true;
					dfs(cx, cy, distance + 1, pos);
					visited[cx][cy] = false;
				}
			}
		}
		if (answer.isEmpty()) {
			answer.offer(new Point(pos, distance));
		} else if (answer.peek().dist < distance) {
			answer.poll();
			answer.offer(new Point(pos, distance));
		} else if (answer.peek().dist == distance) {
			answer.offer(new Point(pos, distance));
		}
		return;
	}
}
