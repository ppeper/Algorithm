package swea;

import java.util.Arrays;
import java.util.Scanner;

class D3_2805 {
    static int mid;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            int size = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                matrix[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            // 기준
            mid = matrix.length / 2;
            for (int i = 0; i < matrix.length; i++) {
                if (i <= mid) {
                    sum += getValue(matrix, i, i);
                } else {
                    sum += getValue(matrix, i, (matrix.length - 1) - i);
                }
            }
            System.out.printf("#%d %d\n", test_case, sum);
        }
    }

    private static int getValue(int[][] matrix, int start, int range) {
        int value = 0;
        for (int j = mid - range; j <= mid + range; j++) {
            value += matrix[j][start];
        }
        return value;
    }
}
