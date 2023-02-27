package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p17135 {

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static LinkedList<Point> enemy;
    static int n, m, d;
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        enemy = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                // 적이면 저장
                if (input == 1) {
                    enemy.add(new Point(i, j));
                }
            }
        }
        // 궁수를 3명 배치한다.
        setArcher(0, 3);
        System.out.println(answer);
    }

    private static void setArcher(int start, int count) {
        if (count == 0) {
            gameStart();
            return;
        }
        for (int i = start; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                setArcher(i + 1, count - 1);
                visited[i] = false;
            }
        }
    }

    private static void gameStart() {
        int kill = 0;
        LinkedList<Point> enemies = new LinkedList<>();
        for (Point e : enemy) {
            enemies.add(new Point(e.x, e.y));
        }
        while (!enemies.isEmpty()) {
            HashSet<Point> attack = new HashSet<>();
            // 공격 당하는 애들
            for (int i = 0; i < m; i++) {
                // 궁수 위치
                if (visited[i]) {
                    // 적의 위치
                    int min = Integer.MAX_VALUE;
                    Point curr = null;
                    for (Point p : enemies) {
                        // 공격거리가 d 이하면 공격하는 친구
                        int dist = distance(n, i, p);
                        if (dist <= d) {
                            if (dist < min) {
                                min = dist;
                                curr = p;
                            } else if (dist == min) {
                                // 맨 왼쪽을 공격
                                if (curr != null && p.y < curr.y) {
                                    curr = p;
                                }
                            }
                        }
                    }
                    // 공격당하는 적이 정해짐
                    if (curr != null) {
                        attack.add(curr);
                    }
                }
            }
            kill += attack.size();
            // 공격당한 적들 삭제
            for (Point p : attack) {
                enemies.remove(p);
            }
            // 위치 앞으로 이동
            for (int i = 0; i < enemies.size(); i++) {
                Point e = enemies.get(i);
                // 성을 지나가면 삭제
                if (n <= e.x + 1) {
                    enemies.remove(e);
                    i--;
                } else {
                    e.x++;
                }
            }
        }
        answer = Math.max(answer, kill);
    }

    private static int distance(int x, int y, Point p) {
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}
