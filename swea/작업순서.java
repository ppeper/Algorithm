package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업순서 {
	
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph = new ArrayList<>();
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int i = 0; i <= v; i++) {
				graph.add(new ArrayList<Integer>());
			}
			int[] in_degree = new int[v + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				in_degree[b]++;
			}
			String order = topological(in_degree);
			System.out.printf("#%d %s\n", testCase, order);
		}
	}

	private static String topological(int[] in_degree) {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < in_degree.length; i++) {
			// 진입차수가 0인곳은 queue에 넣어줌
			if (in_degree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			sb.append(vertex + " ");
			for (int adj: graph.get(vertex)) {
				if (--in_degree[adj] == 0) {
					queue.offer(adj);
				}
			}
		}
		return sb.toString();
	}

}
