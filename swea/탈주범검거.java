package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	
	static int N, M, L;
	static int[][] map;
	static int[][] visited;
	static int answer;
	// 상우하좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	// 7개의 파이프 별로 이동할 수 있는 경로
	static int[][] pipe = {
			{},
			{1, 1, 1, 1},
			{1, 0, 1, 0},
			{0, 1, 0, 1},
			{1, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 1, 1},
			{1, 0, 0, 1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = -1;
				}
			}
			// 탈주범 탐색
			visited[R][C] = 0;
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] {R, C});
			search(queue);
			countPossiblePosition();
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
	
	private static void countPossiblePosition() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != -1) {
					answer++;
				}
			}
		}
	}
	private static void search(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			// 이미 L - 1만큼 이동했으면 종료
			if (visited[curr[0]][curr[1]] == L - 1) continue;
			
			int type = map[curr[0]][curr[1]];
			int[] currPipe = pipe[type];
			// 해당 파이프의 이동가능 여부
			for (int i = 0; i < currPipe.length; i++) {
				if (currPipe[i] == 0) continue;
				int cx = curr[0] + dx[i];
				int cy = curr[1] + dy[i];
				if (cx < 0 || N <= cx || cy < 0 || M <= cy) continue;
				if (visited[cx][cy] != -1 || map[cx][cy] == 0) continue;
				// 이동한 곳이 이동가능 한 pipe인지 확인
				// 이동하려는 파이프의 위치의 상대방이 들어오고 있는지 확인
				if (pipe[map[cx][cy]][(i + 2) % 4] == 1) {
					visited[cx][cy] = visited[curr[0]][curr[1]] + 1;
					queue.offer(new int[] {cx, cy});
				}
			}
		}
	}
}
