package swea;

import java.util.Arrays;
import java.util.Scanner;

class D3_5215 {
    static boolean[] visited;
    static int[][] gradients;
    static int score;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            score = 0;
            visited = new boolean[input[0]];
            gradients = new int[input[0]][2];
            int amount = input[1];
            for (int i = 0; i < input[0]; i++) {
                gradients[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < gradients.length; i++) {
                search(i, 0, amount);
            }
            System.out.printf("#%d %d\n", test_case, score);
        }
    }

    private static void search(int i, int sum, int amount) {
        for (int j = i; j < gradients.length; j++) {
            if (gradients[j][1] <= amount) {
                search(j + 1, sum + gradients[j][0], amount - gradients[j][1]);
            }
        }
        score = Math.max(score, sum);
    }
}
