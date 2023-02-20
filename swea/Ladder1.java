package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
    static int[][] map;
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            int testNumber = Integer.parseInt(br.readLine());
            int x = 0, y = 0;
            map = new int[100][100];
            for (int k = 0; k < map.length; k++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map.length; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[k][j] = input;
                    if (input == 2) {
                        x = k;
                        y = j;
                    }
                }
            }
            System.out.printf("#%d %d\n", testNumber, move(x, y));
        }
    }

    private static int move(int x, int y) {
        int result;
        while (true) {
            // 도착하면 종료
            if (x == 0) {
                result = y;
                break;
            }
            for (int i = 0; i < 3; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (checkRange(cx, cy) && map[cx][cy] == 1) {
                    map[x][y] = -1;
                    x = cx;
                    y = cy;
                }
            }
        }
        return result;
    }

    private static boolean checkRange(int i, int j) {
        return (0 <= i && i < 100 && 0 <= j && j < 100);
    }
}
