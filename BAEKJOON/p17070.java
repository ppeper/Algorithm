package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17070 {

    static int[][] map;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 2, 0);
        System.out.println(answer);
    }

    // 가로:0, 세로:1, 대각선:2
    private static void dfs(int x, int y, int dir) {
        if (x == n && y == n) {
            answer++;
            return;
        }
        switch (dir) {
            case 0:
                // 가로방향
                if (y + 1 <= n && map[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }
                break;
            case 1:
                // 세로방향
                if (x + 1 <= n && map[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                break;
            case 2:
                // 오른쪽, 왼쪽
                if (x + 1 <= n && map[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                if (y + 1 <= n && map[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }
        }
        // 대각선은 모두 같다
        if (x + 1 <= n && y + 1 <= n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
