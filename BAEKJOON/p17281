package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17281 {

	static int answer = 0;
	static int[][] game;
	static int[] player;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		game = new int[n][10];
		visited = new boolean[10];
		player = new int[10];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 1; k <= 9; k++) {
				game[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		// 고정으로 1번선수가 4번타자
		visited[4] = true;
		player[4] = 1;
		play();
		pickOrder(2);
		System.out.println(answer);
	}

	private static void pickOrder(int count) {
		if (count == 10) {
			play();
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				player[i] = count;
				pickOrder(count + 1);
				visited[i] = false;
			}
		}
	}

	private static void play() {
		int startIndex = 1;
		int score = 0;
		for (int i = 0; i < game.length; i++) {
			// 아웃 카운트
			int out = 0;
			// 이닝 시작할때 ground 상황
			boolean[] ground = new boolean[4];
			// 3아웃까지 게임을 진행한다.
			while (out < 3) {
				int hit = game[i][player[startIndex]];
				switch (hit) {
				case 0:
					out++;
					break;
				case 1:
					for (int k = 3; k >= 1; k--) {
						if (ground[k]) {
							if (k == 3) {
								score++;
								ground[k] = false;
								continue;
							}
							ground[k] = false;
							ground[k + 1] = true;
						}

					}
					ground[1] = true;
					break;
				case 2:
					for (int k = 3; k >= 1; k--) {
						if (ground[k]) {
							if (k == 3 || k == 2) {
								score++;
								ground[k] = false;
								continue;
							}
							ground[k] = false;
							ground[k + 2] = true;
						}

					}
					ground[2] = true;
					break;
				case 3:
					for (int k = 3; k >= 1; k--) {
						if (ground[k]) {
							ground[k] = false;
							score++;
						}
					}
					ground[3] = true;
					break;
				case 4:
					for (int j = 1; j <= 3; j++) {
						if (ground[j]) {
							score++;
							ground[j] = false;
						}
					}
					score += 1;
					break;
				}
				// 다음 주자
				if (startIndex + 1 == 10) {
					startIndex = 1;
				} else {
					startIndex++;
				}
			}
		}
		answer = Math.max(answer, score);
	}
}
