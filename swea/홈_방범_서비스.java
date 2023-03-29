package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홈_방범_서비스 {

    static int n, m;
    static int[][] visited;
    static List<int[]> list;
    static int maxHouse;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxHouse = 0;
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) list.add(new int[]{i, j});
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 1; k <= n + 1; k++) {
                        bfs(new int[]{i, j}, k);
                        calculate(k);
                    }
                }
            }
            System.out.printf("#%d %d\n", testCase, maxHouse);
        }
    }

    private static void calculate(int k) {
        int cost = k * k + (k - 1) * (k - 1);
        int count = 0;
        for (int[] p : list) {
            if (visited[p[0]][p[1]] != 0) count++;
        }
        int house = count * m;
        if (0 <= house - cost) {
            maxHouse = Math.max(maxHouse, count);
        }
    }

    private static void bfs(int[] p, int k) {
        visited = new int[n][n];
        visited[p[0]][p[1]] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (k <= visited[curr[0]][curr[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + move[i][0], ny = curr[1] + move[i][1];
                if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
                if (visited[nx][ny] != 0) continue;
                visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
