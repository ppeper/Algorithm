package swea;


import java.util.Scanner;

class D3_12051 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            long N = Long.parseLong(sc.next());
            int P = Integer.parseInt(sc.next());
            int G = Integer.parseInt(sc.next());
            // 현재 진적이 있는데 전체가 100프로
            if (P != 100 && G == 100) {
                System.out.println("#" + test_case + " Broken");
            } else if (P != 0 && G == 0) { // 현재 이긴적이 있는데 전체가 0프로
                System.out.println("#" + test_case + " Broken");
            } else {
                if (P == 0) {
                    System.out.println("#" + test_case + " Possible");
                } else {
                    boolean check = false;
                    for (long game = 1; game <= N; game++) {
                        // 퍼센트가 나오는 게임 수
                        if ((P * game) % 100 == 0) {
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println("#" + test_case + " Possible");
                    } else {
                        System.out.println("#" + test_case + " Broken");
                    }
                }
            }
        }
    }
}
