package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<Character>();
			char[] input = br.readLine().toCharArray();
			int flag = 1;
			for (char c : input) {
				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					if (c == '(' || c == '{' || c == '[' || c == '<') {
						stack.push(c);
					} else {
						char curr = stack.pop();
						if (c == ')') {
							if (curr != '(') {
								flag = 0;
								break;
							}
						} else if (c == '}') {
							if (curr != '{') {
								flag = 0;
								break;
							}
						} else if (c == ']') {
							if (curr != '[') {
								flag = 0;
								break;
							}
							
						} else if (c == '>') {
							if (curr != '<') {
								flag = 0;
								break;
							}
						}
						
					}
				}
			}
			System.out.printf("#%d %d\n", i, flag);
		}
	}
}
