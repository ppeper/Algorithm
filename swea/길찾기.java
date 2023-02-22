package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 길찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int test = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] route1 = new int[100];
			int[] route2 = new int[100];
			int answer = 0;
			// 길 세팅
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (route1[a] == 0) {
					route1[a] = b;
				} else {
					route2[a] = b;
				}
			}
			Stack<Integer> stack = new Stack<Integer>();
			if (route1[0] != 0) {
				stack.push(route1[0]);
			}
			if (route2[0] != 0) {
				stack.push(route2[0]);
			}
			// dfs 탐색
			while (!stack.isEmpty()) {
				int dest = stack.pop();
				// 찾는 B의 위치라면 가능
				if (dest == 99) {
					answer = 1;
					break;
				}
				if (route1[dest] != 0) {
					stack.push(route1[dest]);
				}
				if (route2[dest] != 0) {
					stack.push(route2[dest]);
				}
			}
			System.out.printf("#%d %d\n", test, answer);
		}
		
	}
}
