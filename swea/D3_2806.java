package swea;

import java.util.Scanner;

class D3_2806 {
    static int[] board;
    static int count;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int size = Integer.parseInt(sc.nextLine());
            board = new int[size];
            count = 0;
            putChess(0, size);
            System.out.printf("#%d %d\n", test_case, count);
        }
    }

    private static void putChess(int row, int size) {
        if (row == size) {
            count++;
            return;
        }
        // 둘 수 있는 돌 위치 확인
        for (int pos = 0; pos < board.length; pos++) {
            if (isValidPosition(row, pos)) {
                board[row] = pos;
                putChess(row + 1, size);
            }
        }
    }

    private static boolean isValidPosition(int row, int pos) {
        for (int i = 0; i < row; i++) {
            if (board[i] == pos || Math.abs(board[i] - pos) == row - i) {
                return false;
            }
        }
        return true;
    }
}
