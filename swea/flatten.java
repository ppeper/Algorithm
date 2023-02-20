package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int dump = Integer.parseInt(br.readLine());
			int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			while (0 < dump--) {
				int[] index = findMinAndMax(array);
				array[index[0]]++;
				array[index[1]]--;
			}
			int[] index = findMinAndMax(array);
			System.out.printf("#%d %d\n", i + 1, array[index[1]] - array[index[0]]);
		}
	}
	
	static int[] findMinAndMax(int[] array) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int indexMax = 0;
		int indexMin = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				indexMin = i;
			}
			if (max < array[i]) {
				max = array[i];
				indexMax = i;
			}
		}
		return new int[] {indexMin, indexMax};
	}
}
