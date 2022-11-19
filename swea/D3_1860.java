package swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class D3_1860 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] input = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = input[0];
            int M = input[1];
            int K = input[2];
            int[] person;
            person = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 도착이 빠른순
            Arrays.sort(person);
            int amount = 0;
            int make = 0;
            boolean check = false;
            for (int d = 0; d < person.length; d++) {
                int order = person[d];
                // 만드는 시간보다 늦게 들어옴
                if (M <= order) {
                    // 해당 들어온 시간 만큼 붕어빵을 만들어놈
                    if (make < order / M) {
                        amount += ((order / M) - make) * K;
                        make = (order / M);
                    }
                    if (0 < amount) {
                        amount--;
                    } else {
                        check = true;
                        break;
                    }
                } else {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.printf("#%d %s\n", test_case, "Impossible");
            } else {
                System.out.printf("#%d %s\n", test_case, "Possible");
            }
        }
    }
}
