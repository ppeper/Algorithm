package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 프로세서_연결하기 {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int n, maxCore, minConnect;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            n = Integer.parseInt(br.readLine());
            minConnect = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;
            list = new ArrayList<>();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i][j] = input;
                    if (input == 1) {
                        if (i == 0 || j == 0 || i == n - 1 || j == n - 1) continue;
                        list.add(new Node(i, j));
                    }
                }
            }
            dfs(0, 0, 0);
            System.out.printf("#%d %d\n", testCase, minConnect);
        }
    }

    private static void dfs(int i, int core, int connect) {
        if (i == list.size()) {
            if (maxCore < core) {
                maxCore = core;
                minConnect = connect;
            } else if (maxCore == core) {
                // 더 작은 값으로 업데이트
                minConnect = Math.min(minConnect, connect);
            }
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (isCanConnect(list.get(i), j)) {
                int count = markConnect(list.get(i), j, 2);
                dfs(i + 1, core + 1, connect + count);
                markConnect(list.get(i), j, 0);
            }
        }
        dfs(i + 1, core, connect);
    }

    private static int markConnect(Node node, int i, int value) {
        int x = node.x + move[i][0], y = node.y + move[i][1], count = 0;
        while (0 <= x && x < n && 0 <= y && y < n) {
            map[x][y] = value;
            x += move[i][0];
            y += move[i][1];
            count++;
        }
        return count;
    }

    private static boolean isCanConnect(Node node, int j) {
        int x = node.x + move[j][0], y = node.y + move[j][1];
        while (0 <= x && x < n && 0 <= y && y < n) {
            if (map[x][y] != 0) return false;
            x += move[j][0];
            y += move[j][1];
        }
        return true;
    }

}
