import java.util.*;

public class Palindrome {
	static Stack<Character> stack = new Stack<Character>();
	
	public static boolean checkInput(String input) {
		char c [] = input.toCharArray();
		int mid = c.length / 2;
		//짝수 일떄
		if((input.length() % 2) == 0) {
			//절반 push
			for(int i = 0; i < mid; i++) {
				stack.push(c[i]);
			}
			//중간이후 peek과 들어온 input 확인
			for(int i = mid; i < c.length; i++) {
				if(stack.peek() == c[i]) stack.pop();
				else return false;
			}
		} else { //홀수 일때
			//절반 push
			for(int i = 0; i < mid; i++) {
				stack.push(c[i]);
			}
			//중간 + 1은 문자열이 홀수이기떄문에 생각x
			for(int i = mid+1; i < c.length; i++) {
				if(stack.peek() == c[i]) stack.pop();
				else return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("검사할 회문입력 >> ");
			String input = sc.next();
			if(input.equals("그만")) break;
			if(checkInput(input)) System.out.println("YES!");
			else System.out.println("NO!");
		}
	}

}
