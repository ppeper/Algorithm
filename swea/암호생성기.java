package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class 암호생성기 {
	
	static int[] dx = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int testCase = Integer.parseInt(br.readLine());
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int value: input) {
				queue.offer(value);
			}
			int x = 0;
			while (true) {
				int curr = queue.poll() - dx[x % 5];
				x++;
				if (curr < 0) {
					curr = 0;
				}
				queue.offer(curr);
				if (curr == 0) {
					break;
				}
			}
			String list = queue.stream().map(String::valueOf).collect(Collectors.joining(" "));
			System.out.printf("#%d %s\n", testCase, list);
		}
	}
}
