package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17406 {

    static int[][] board;
    static int[][] basic;
    static int[][] copy;
    static int[][] rotate;
    static int[] order;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 회전 연산의 개수
        int k = Integer.parseInt(st.nextToken());
        order = new int[k + 1];
        visited = new boolean[k + 1];
        board = new int[n + 1][m + 1];
        basic = new int[n + 1][m + 1];
        copy = new int[n + 1][m + 1];
        rotate = new int[k + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken());
                board[i][j] = input;
                basic[i][j] = input;
            }
        }
        // 회전연산 저장
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            rotate[i][0] = Integer.parseInt(st.nextToken());
            rotate[i][1] = Integer.parseInt(st.nextToken());
            rotate[i][2] = Integer.parseInt(st.nextToken());
        }
        pickRotateOrder(1, k);
        System.out.println(answer);
    }

    private static void pickRotateOrder(int i, int k) {
        if (i == k + 1) {
            for (int j = 0; j < board.length; j++) {
                board[j] = basic[j].clone();
            }
            rotate();
            calculate();
            return;
        }
        for (int j = 1; j <= k; j++) {
            if (!visited[j]) {
                visited[j] = true;
                order[j] = i;
                pickRotateOrder(i + 1, k);
                visited[j] = false;
            }
        }
    }

    private static void rotate() {
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        // 회전하는 순서
        for (int i = 1; i < order.length; i++) {
            int[] rotateArray = rotate[order[i]];
            int startX = rotateArray[0] - rotateArray[2];
            int startY = rotateArray[1] - rotateArray[2];
            int endX = rotateArray[0] + rotateArray[2];
            int endY = rotateArray[1] + rotateArray[2];
            // 회전 진행 -> 보게 되면 갈수록 x, y값의 범위가 1씩 줄어듬
            rotateMap(startX, startY, endX, endY);
        }
    }

    private static void rotateMap(int startX, int startY, int endX, int endY) {
        while (startX != endX && startY != endY) {
            // 마지막 배열은 1개로 되어있으므로 회전이 없다
            // 1. 맨위
            for (int col = startY; col < endY; col++) {
                board[startX][col + 1] = copy[startX][col];
            }
            // 2. 오른쪽
            for (int row = startX; row < endX; row++) {
                board[row + 1][endY] = copy[row][endY];
            }
            // 3. 아래
            for (int col = endY; startY < col; col--) {
                board[endX][col - 1] = copy[endX][col];
            }
            // 4. 왼쪽
            for (int row = endX; startX < row; row--) {
                board[row - 1][startY] = copy[row][startY];
            }
            // 한번 회전이 진행하면 x, y의 값을 1씩 줄여줌
            startX++;
            startY++;
            endX--;
            endY--;
        }
        // 현재 배열 상태 저장
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
    }

    private static void calculate() {
        for (int i = 1; i < board.length; i++) {
            int sum = Arrays.stream(board[i]).sum();
            answer = Math.min(answer, sum);
        }
    }
}