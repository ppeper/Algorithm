package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class mostFrequent {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int testNumber = Integer.parseInt(br.readLine()); 
			int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Map<Integer, Long> map = Arrays.stream(array)
				.boxed()
				.collect(Collectors.groupingBy(num -> num, Collectors.counting()));
			Optional<Integer> key = map.keySet().stream()
				.sorted(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						if (map.get(o1) == map.get(o2)) {
							return o2 - o1;
						}
						return map.get(o2).compareTo(map.get(o1));
					}
				})
				.findFirst();
			System.out.printf("#%d %d\n", testNumber, Integer.valueOf(key.get()));
		}
	}
}
