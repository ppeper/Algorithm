package swea;

import java.util.Arrays;
import java.util.Scanner;

class D3_1209 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(sc.nextLine());
            int max = 0;
            int[][] matrix = new int[100][100];
            // 세팅
            for (int i = 0; i < 100; i++) {
                matrix[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            // 가로 세로 합 크기
            for (int i = 0; i < matrix.length; i++) {
                int row = 0, col = 0;
                for (int j = 0; j < matrix.length; j++) {
                    row += matrix[i][j];
                    col += matrix[j][i];
                }
                max = Math.max(Math.max(row, col), max);
            }
            // 대각선
            int diagonal_down = 0, diagonal_up = 0;
            for (int i = 0; i < matrix.length; i++) {
                diagonal_down += matrix[i][i];
            }
            for (int i = matrix.length - 1; 0 <= i; i--) {
                diagonal_up += matrix[i][matrix.length - 1 - i];
            }
            max = Math.max(Math.max(diagonal_down, diagonal_up), max);
            System.out.printf("#%d %d\n", T, max);
        }
    }
}
