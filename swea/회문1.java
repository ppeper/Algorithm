package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 회문1 {
    static int length;
    static int count;
    static String[][] matrix;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            length = Integer.parseInt(br.readLine());
            count = 0;
            matrix = new String[8][8];
            for (int i = 0; i < 8; i++) {
                matrix[i] = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
            }
            if (length == 1) {
                System.out.printf("#%d %d\n", test_case, matrix.length * matrix.length);
                continue;
            }
            // 회문 찾기
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length - length; j++) {
                    // 가로 방향
                    checkIsPalindrome(i, j, 1);
                    // 세로 방향
                    checkIsPalindrome(j, i, -1);
                }
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
 
    private static void checkIsPalindrome(int i, int j, int direction) {
        StringBuilder sb = new StringBuilder();
        if (direction == 1) {
            for (int k = 0; k < length; k++) {
                sb.append(matrix[i][j + k]);
            }
        } else {
            for (int k = 0; k < length; k++) {
                sb.append(matrix[i + k][j]);
            }
        }
        String word = sb.toString();
        String word_reverse = sb.reverse().toString();
        if (word_reverse.equals(word)) {
            count++;
        }
    }
}