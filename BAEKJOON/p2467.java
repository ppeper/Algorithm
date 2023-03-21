package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2467 {
	
	static int n;
	static int[] result;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new int[2];
		n = Integer.parseInt(br.readLine());
		int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		search(0, n - 1, map);
		System.out.println(result[0] + " " + result[1]);
	}

	// 투 포인터의 값의 합했을때
	// 1. 음수면 앞쪽을 1 증가
	// 2. 양수면 뒤쪽을 -1 감소
	private static void search(int start, int end, int[] map) {
		if (start == end) {
			return;
		}
		int diff = map[start] + map[end];
		if (diff < 0) {
			if (Math.abs(diff) < answer) {
				answer = Math.abs(diff);
				result[0] = map[start];
				result[1] = map[end];
			}
			search(start + 1, end, map);
		} else {
			if (Math.abs(diff) < answer) {
				answer = Math.abs(diff);
				result[0] = map[start];
				result[1] = map[end];
			}
			search(start, end - 1, map);
		}
	}
}