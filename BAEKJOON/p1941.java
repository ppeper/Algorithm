package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1941 {

    static char[][] map;
    static boolean[] visited;
    static int[] X;
    static int[] Y;
    static boolean[] checked;
    static int answer = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        checked = new boolean[25];
        X = new int[25];
        Y = new int[25];
        for (int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                map[i][j] = input[j];
            }
        }
        for (int i = 0; i < 25; i++) {
            X[i] = i % 5;
            Y[i] = i / 5;
        }
        // 검색 -> 7명 -> S가 4개이상
        // 조합
        combination(new int[7], 0, 0);
        System.out.println(answer);
    }

    private static void combination(int[] list, int start, int count) {
        if (count == 7) {
            checkState(list);
            return;
        }
        for (int i = start; i < 25; i++) {
            if (!checked[i]) {
                checked[i] = true;
                list[count] = i;
                combination(list, i + 1, count + 1);
                checked[i] = false;
            }
        }
    }

    // 유효한지 확인 후 S가 4개 이상인지 확인
    private static void checkState(int[] list) {
        visited = new boolean[7];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int S = 0;
        queue.offer(0);
        visited[0]= true;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            int x = X[list[next]];
            int y = Y[list[next]];
            if (map[x][y] == 'S') S++;
            count++;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && cx == X[list[j]] && cy == Y[list[j]]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        if (count == 7 && 4 <= S) answer++;
    }
}
