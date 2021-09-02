package ArrayStackEx;

import java.util.*;

public class Parentheses {
	static Stack<Character> stack = new Stack<Character>();
	
	public static boolean checkInput(String input) {
		if((input.length() % 2) == 0) {
			for(char c: input.toCharArray()) {
				if(c == '(' || c == '{') { stack.push(c);
				}
				else if(c == '}') {
					if(stack.isEmpty()) return false;
					else {
						if(stack.peek() == '{') {
							stack.pop();
						}
					}
				}
				else if(c == ')') {
					if(stack.isEmpty()) return false;
					else {
						if(stack.peek() == '(') {
							stack.pop();
						}
					}
				}
				else return false;
			}
		} else {
			return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("검사할 괄호나열>> ");
			String input = sc.next();
			if(input.equals("그만")) break;
			if(checkInput(input)) System.out.println("YES!");
			else System.out.println("NO!");
		}
	}

}
