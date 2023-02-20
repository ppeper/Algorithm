package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Magnetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int count = 0;
            int size = Integer.parseInt(br.readLine());
            int[][] map = new int[size][size];
            for (int j = 0; j < size; j++) {
                map[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            // 아래로 확인하면서 N, S를 확인
            for (int j = 0; j < size; j++) {
                int magnetic = 0;
                for (int row = 0; row < size; row++) {
                    // 둘이 붙는다
                    if (map[row][j] == 2 && magnetic == 1) {
                        count++;
                        magnetic = 0;
                    }
                    if (map[row][j] == 1) {
                        magnetic = 1;
                    }
                }
            }
            System.out.printf("#%d %d\n", i, count);
        }
    }
}
