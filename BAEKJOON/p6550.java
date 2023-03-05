package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6550 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input;
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			int index = 0;
			String s = st.nextToken();
			String t = st.nextToken();
			
			for (int i = 0; i < t.length(); i++) {
				if (s.charAt(index) == t.charAt(i)) {
					index++;
				}
				if (index == s.length()) break;
			}
			
			if (index == s.length())
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}