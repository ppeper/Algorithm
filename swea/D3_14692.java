package swea;

import java.util.Scanner;

class D3_14692 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int tree = sc.nextInt();
            if (tree % 2 == 0) {
                System.out.println("#" + test_case + " Alice");
            } else {
                System.out.println("#" + test_case + " Bob");
            }
        }
    }
}