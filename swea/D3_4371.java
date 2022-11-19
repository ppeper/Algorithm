package swea;

import java.util.Scanner;

class D3_4371 {
    static int[] ship;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            ship = new int[N];
            visited = new boolean[N];
            int start = 1;
            int count = 0;
            // init
            for (int i = 0; i < N; i++) {
                ship[i] = Integer.parseInt(sc.nextLine());
            }
            // 항구 모두 확인
            for (int i = 1; i < ship.length; i++) {
                // i번째 항구 체크
                if (!visited[i]) {
                    visited[i] = true;
                    int day = ship[i] - start;
                    for (int j = i + 1; j < ship.length; j++) {
                        if (ship[j] % day == start) {
                            visited[j] = true;
                        }
                    }
                    count++;
                }
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}