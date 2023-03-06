package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 보급로 {
	
	static class Point implements Comparable<Point> {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}
		
	}
	
	static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] map;
	static int answer;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(input[j]);					
				}
			}
			// bfs 돌기
			bfs(0, 0);
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}

	private static void bfs(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(x, y, 0));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			// 도착지점이라면
			if (p.x == map.length - 1 && p.y == map.length - 1) {
				answer = Math.min(answer, p.dist);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + move[i][0], ny = p.y + move[i][1];
				
				if (nx < 0 || map.length <= nx || ny < 0 || map.length <= ny) continue;
				if (visited[nx][ny]) continue;
				// 현재 가려는 곳의 도로 비용을 더해줌
				visited[nx][ny] = true;
				queue.offer(new Point(nx, ny, p.dist + map[nx][ny]));
			}
			
		}
	}
}