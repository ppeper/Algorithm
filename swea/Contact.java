package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
	
	static class Point {
		int to, level;
		public Point(int to, int level) {
			this.to = to;
			this.level = level;
		}
	}
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			answer = Integer.MIN_VALUE;
			visited = new boolean[101];
			graph = new ArrayList<ArrayList<Integer>>();
			// 기본 graph 초기화
			for (int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<Integer>());
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n / 2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
			}
			bfs(start);
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}

	private static void bfs(int start) {
		Queue<Point> queue = new LinkedList<>();
		ArrayList<Point> list = new ArrayList<>();
		queue.offer(new Point(start, 1));
		visited[start] = true;
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			for (int adj : graph.get(curr.to)) {
				if (!visited[adj]) {
					visited[adj] = true;
					Point dest = new Point(adj, curr.level + 1);
					list.add(dest);
					queue.offer(dest);
				}
			}
		}
		list.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.level == o2.level) {
					return o2.to - o1.to;
				}
				return o2.level - o1.level;
			}
		});
		answer = list.get(0).to;
	}
}
