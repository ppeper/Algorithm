package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			int count = 0;
			int T = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String source = br.readLine();
			for (int j = 0; j <= source.length() - target.length(); j++) {
				if (target.equals(source.substring(j, j + target.length()))) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", T, count);
		}
	}
}
