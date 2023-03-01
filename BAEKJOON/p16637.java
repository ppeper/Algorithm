package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16637 {

    static char[] input;
    static int answer = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        // 괄호 치기
        dfs(2, input[0] - '0');
        System.out.println(answer);
    }

    private static void dfs(int index, int sum) {
        if (n <= index) {
            answer = Math.max(answer, sum);
            return;
        }
        // 괄호를 다음 숫자에 친경우
        // 범위를 넘어가면 안된다.
        if (index + 2 < n) {
            int buffer = calculate(input[index] - '0', input[index + 2] - '0', input[index + 1]);
            int currentValue = calculate(sum, buffer, input[index - 1]);
            dfs(index + 4, currentValue);
        }
        // 괄호를 다음 숫자에 안친 경우
        dfs(index + 2, calculate(sum, input[index] - '0', input[index - 1]));
    }

    private static int calculate(int x, int y, char c) {
        switch (c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            default:
                return x * y;
        }
    }
}
