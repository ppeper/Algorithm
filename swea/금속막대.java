package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 금속막대 {

	static class Point {
		int front, back;

		public Point(int front, int back) {
			this.front = front;
			this.back = back;
		}
		
	}
	static List<Point> list;
	static List<Point> path;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new ArrayList<Point>();
			path = new ArrayList<Point>();
			while (st.hasMoreTokens()) {
				int front = Integer.parseInt(st.nextToken());
				int back = Integer.parseInt(st.nextToken());
				list.add(new Point(front, back));
			}
			for (Point p : list) {
				search(p);
				if (path.size() == n) {
					break;
				}
				path.clear();
			}
			StringBuilder sb = new StringBuilder();
			for (Point p : path) {
				sb.append(p.front + " " + p.back + " ");
			}
			System.out.println("#" + testCase + " " + sb);
		}
	}

	private static void search(Point p) {
		path.add(p);
		for (Point next : list) {
			if (p.back == next.front) {
				search(next);
			}
		}
	}
}
