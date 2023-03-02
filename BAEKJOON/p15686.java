package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p15686 {
	
	static int maxLength = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		if (2 < n) {
			for (int start = 0; start < n - 2; start++) {
				// 시작점 부터 마지막을 빼가면서 확인 해봄
				for (int end = n - 1; start < end; end--) {
					if (list[end] < list[start] + list[start + 1]) {
						maxLength = Math.max(maxLength, end - start + 1);
					}
				}
			}
		} else {
			maxLength = n;
		}
		System.out.println(maxLength);
	}
}
