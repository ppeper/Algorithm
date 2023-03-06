package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p17472 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Area implements Comparable<Area> {
        int src, dst, dist;

        public Area(int src, int dst, int dist) {
            super();
            this.src = src;
            this.dst = dst;
            this.dist = dist;
        }

        // 거리가 짧은 순으로
        @Override
        public int compareTo(Area o) {
            return this.dist - o.dist;
        }

        @Override
        public String toString() {
            return "Area [src=" + src + ", dst=" + dst + ", dist=" + dist + "]";
        }

    }

    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, m;
    static int area = 1;
    static int[][] map;
    static PriorityQueue<Area> pq;
    static boolean[][] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initParent();
        // 각 섬별로 연결되는 최소의 길이를 구해줘야한다.
        // 해당하는 나라와 다리연결비용으로 최소 간선을 뽑아줘야함
        // 모두 연결되어있으면 되기 때문에 MST방식으로 진행
        checkBrideConnection();
        int answer = kruskal();
        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
    private static int kruskal() {
        int result = 0, count = 0;
        while (!pq.isEmpty()) {
            Area area = pq.poll();
            // 둘이 연결이 아직 안되어 있다면
            if (getParent(area.src) != getParent(area.dst)) {
                // 다리의 길이 가중치를 더해준다.
                result += area.dist;
                count++;
                // union을 통하여 둘이 같은 집합으로 바꿈
                union(area.src, area.dst);
            }
        }
        if (count != area - 2) {
            return 0;
        }
        return result;
    }
    private static void checkBrideConnection() {
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    search(i, j, map[i][j]);
                }
            }
        }
    }

    private static void search(int x, int y, int node) {
        // 가로 세로 확인하면서 나라와 연결관계 저장
        for (int i = 0; i < 4; i++) {
            int bride = 0, dest = 0;
            boolean conn = false;
            int nx = x, ny = y;
            while (true) {
                nx = nx + move[i][0];
                ny = ny + move[i][1];
                if (nx < 0 || n <= nx || ny < 0 || m <= ny) break;
                // 다른 지역안만날때 까지 길이 구함
                if (map[nx][ny] == 0) {
                    bride++;
                } else if (map[nx][ny] == node) {
                    // 길이를 한 방향으로 구하다가 다시 내 지역을 만남 -> 지금까지 구한 bride 초기화
                    bride = 0;
                } else {
                    // 다른 나라와 연결됨
                    dest = map[nx][ny];
                    conn = true;
                    break;
                }

            }
            // bride 길이가 2이상이어야 한다
            if (bride < 2 || !conn) continue;
            // 그래프간 연결관계 저장
            pq.offer(new Area(node, dest, bride));
        }
    }

    private static void initParent() {
        visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    map[i][j] = area;
                    visited[i][j] = true;
                    count++;
                    bfs(i, j);
                    area++;
                }
            }
        }
        parent = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            parent[i] = i;
        }
    }

    // 나라의 개수를 구하면서 map에 나라의 번호로 바꿔줌
    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + move[i][0], ny = p.y + move[i][1];
                if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = area;
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        // 작은거에 합침
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int getParent(int node) {
        if (parent[node] != node) {
            parent[node] = getParent(parent[node]);
        }
        return parent[node];
    }
}