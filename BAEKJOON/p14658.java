package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14658 {
	
	static int n, m, l, k;
	static int[][] list;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int[] starA: list) {
			for (int[] starB : list) {
				int count = 0;
				int x = starA[0], y = starB[1];
				int nx = x + l, ny = y + l;
				for (int[] starC : list) {
					if (x <= starC[0] && starC[0] <= nx && y <= starC[1] && starC[1] <= ny) {
						count++;
					}
				}
				answer = Math.max(answer, count);
			}
		}
		System.out.println(k - answer);
	}
}
