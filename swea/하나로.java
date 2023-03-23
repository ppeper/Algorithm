package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로 {
	
	static class Point implements Comparable<Point> {
		int node;
		double weight;

		public Point(int node, double weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			double diff = this.weight - o.weight;
			if (diff < 0) {
				return -1;
			}
			return 1;
		}
		
	}
	
	static boolean[] visited;
	static double answer;
	static double E;
	static PriorityQueue<Point> pq;
	static List<LinkedList<Point>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			answer = 0;
			visited = new boolean[n];
			int[] src = new int[n];
			int[] dest = new int[n];
			graph = new ArrayList<LinkedList<Point>>();
			for (int i = 0; i < n; i++) {
				graph.add(new LinkedList<Point>());
			}
			pq = new PriorityQueue<Point>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				dest[i] = Integer.parseInt(st.nextToken());			
			}
			E = Double.parseDouble(br.readLine());
			// 각 노드간 가중치 계산
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					double a = Math.pow(Math.abs(src[i] - src[j]), 2.0);
					double b = Math.pow(Math.abs(dest[i] - dest[j]), 2.0);
					double dist = (a + b) * E;
					graph.get(i).add(new Point(j, dist));
					graph.get(j).add(new Point(i, dist));
				}
			}
			pq.add(new Point(0, 0));
			while (!pq.isEmpty()) {
				Point p = pq.poll();
				if (!visited[p.node]) {
					visited[p.node] = true;
					answer += p.weight;
					for (Point adj : graph.get(p.node)) {
						if (!visited[adj.node]) {
							pq.offer(adj);
						}
					}
				}
			}
			System.out.printf("#%d %.0f\n", testCase, answer);
		}
	}
}
