package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			Stack<Integer> stack = new Stack<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] numbers = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
			for (int num : numbers) {
				if (stack.isEmpty()) {
					stack.push(num);
				} else {
					if (stack.peek() == num) {
						stack.pop();
					} else {
						stack.push(num);
					}
				}
			}
			String num = stack.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(""));
			System.out.printf("#%d %s\n", testCase, num);
		}
		
	}
}
