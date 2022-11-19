package swea;

import java.util.Arrays;
import java.util.Scanner;

class D3_11285 {
    static double[] radius = {
            Math.pow(20, 2),
            Math.pow(40, 2),
            Math.pow(60, 2),
            Math.pow(80, 2),
            Math.pow(100, 2),
            Math.pow(120, 2),
            Math.pow(140, 2),
            Math.pow(160, 2),
            Math.pow(180, 2),
            Math.pow(200, 2)
    };
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int score = 0;
            int size = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < size; i++) {
                int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                // 점수 구하기
                for (int j = 0; j < radius.length; j++) {
                    if (Math.pow(input[0], 2) + Math.pow(input[1], 2) <= radius[j]) {
                        score += (10 - j);
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, score);
        }
    }
}
