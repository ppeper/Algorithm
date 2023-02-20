package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class view {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int size = Integer.parseInt(br.readLine());
			int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int count = 0;
			for (int j = 2; j < array.length - 2; j++) {
				int sourceHeight = array[j];
				int height = getHeight(array, j);
				if (height < sourceHeight) {
					count += sourceHeight - height;
				}
			}
			System.out.printf("#%d %d\n", i + 1, count);
		}
	}
	
	static int getHeight(int[] array, int index) {
		int height = 0;
		// 양옆 두개 중 가장 높은 높이 확인
		for (int i = index - 2; i <= index + 2; i++) {
			if (i == index) continue;
			height = Math.max(height, array[i]);
		}
		return height;
	}
}
