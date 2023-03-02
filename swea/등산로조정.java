package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조정 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer, k;
    static int maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= test; testCase++) {
            answer = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            visited = new boolean[n][n];
            maxLength = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i][j] = input;
                    maxLength = Math.max(maxLength, input);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == maxLength) {
                        visited[i][j] = true;
                        dfs(i, j, 1, maxLength, true);
                        visited[i][j] = false;
                    }
                }
            }
            System.out.printf("#%d %d\n", testCase, answer);
        }
    }

    private static void dfs(int x, int y, int i, int height, boolean canDig) {
        for (int j = 0; j < 4; j++) {
            // 더 큰 길이로 업데이트
            if (answer < i) {
                answer = i;
            }
            int cx = x + dx[j];
            int cy = y + dy[j];
            if (0 <= cx && cx < map.length && 0 <= cy && cy < map.length
                && !visited[cx][cy]) {
                // 더 크거나 같을때
                if (height <= map[cx][cy]) {
                    // 아직 안깍았고 만약 깍았을때 갈 수 있으면
                    if (canDig && map[cx][cy] - k < height) {
                        visited[cx][cy] = true;
                        dfs(cx, cy, i + 1, height - 1, false);
                        visited[cx][cy] = false;
                    }
                } else {
                    visited[cx][cy] = true;
                    dfs(cx, cy, i + 1, map[cx][cy], canDig);
                    visited[cx][cy] = false;
                }
            }
        }
    }
}
