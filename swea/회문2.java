package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 회문2 {
	static int length;
    static int maxLength;
    static String[][] matrix;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            length = 2;
            maxLength = 0;
            matrix = new String[100][100];
            for (int i = 0; i < 100; i++) {
                matrix[i] = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
            }
            // 회문 찾기
            while (length <= matrix.length) {
            	for (int i = 0; i < matrix.length; i++) {
            		for (int j = 0; j <= matrix.length - length; j++) {
            			// 가로 방향
            			checkIsPalindrome(i, j, 1);
            			// 세로 방향
            			checkIsPalindrome(j, i, -1);
            		}
            	}
            	length++;
            }
            System.out.printf("#%d %d\n", test_case, maxLength);
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
            maxLength = Math.max(maxLength, word.length());
        }
    }
}