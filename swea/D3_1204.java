package swea;

import java.util.Arrays;
import java.util.Scanner;

class D3_1204 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int number = Integer.parseInt(sc.nextLine());
            int count = 0;
            int maxNumber = -1;
            int[] list = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] numbers = Arrays.stream(list).distinct().toArray();
            // 최대 개수 찾기
            for (int num : numbers) {
                int temp = (int) Arrays.stream(list).filter(x -> x == num).count();
                if (count < temp) {
                    count = temp;
                    maxNumber = num;
                } else if (count == temp && maxNumber < num) {
                    maxNumber = num;
                }
            }
            System.out.printf("#%d %d\n", number, maxNumber);
        }
    }
}
