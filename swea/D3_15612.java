package swea;

import java.util.Scanner;

class D3_15612 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String[][] rook = new String[8][8];
            int count = 0;
            for (int i = 0; i < 8; i++) {
                String input = sc.next();
                String[] list = input.split("");
                for (int j = 0; j < list.length; j++) {
                    if (list[j].equals("O")) count++;
                    rook[i][j] = list[j];
                }
            }
            if (checkState(rook) || 8 != count) {
                System.out.println("#" + test_case + " no");
            } else {
                System.out.println("#" + test_case + " yes");
            }
        }
    }

    private static boolean checkState(String[][] rook) {
        for (int i = 0; i < rook.length; i++) {
            for (int j = 0; j < rook[i].length; j++) {
                if (rook[i][j].equals("O")) {
                    if (canAttack(rook, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean canAttack(String[][] rook, int i, int j) {
        for (int row = i + 1; row < rook.length; row++) {
            // 공격 가능
            if (rook[row][j].equals("O")) {
                return true;
            }
        }
        for (int col = j + 1; col < rook.length; col++) {
            // 공격 가능
            if (rook[i][col].equals("O")) {
                return true;
            }
        }
        return false;
    }
}