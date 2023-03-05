package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 무선충전 {

	static class Battery {
		int id, x, y, c, p;

		public Battery(int id, int x, int y, int c, int p) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

	}

	// 상,우,하,좌
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };
	static int[][] move;
	static int sum;
	static Battery[] ap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			sum = 0;
			// 사용자 이동 정보 받기
			move = new int[2][m + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// BC의 정보 받기
			ap = new Battery[a];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap[i] = new Battery(i, x, y, c, p);
			}
			// 사용자 이동하면서 배터리 충전하기
			chargeBattery(1, 1, 10, 10);
			System.out.printf("#%d %d\n", testCase, sum);
		}
	}

	private static void chargeBattery(int x1, int y1, int x2, int y2) {
		// 사용자 이동
		for (int i = 0; i < move[0].length; i++) {
			// 좌표 이동하기
			x1 = x1 + dx[move[0][i]];
			y1 = y1 + dy[move[0][i]];
			x2 = x2 + dx[move[1][i]];
			y2 = y2 + dy[move[1][i]];
			// 현재 얻을 수 있는 최대 배터리 차징
			ArrayList<Battery> listA = getAvailableBattery(x1, y1);
			ArrayList<Battery> listB = getAvailableBattery(x2, y2);
			int charge = 0;
			if (listA.size() != 0 && listB.size() != 0) {
				for (Battery b1 : listA) {
					for (Battery b2 : listB) {
						if (b1.id == b2.id) {
							charge = Math.max(charge, b1.p);
						} else {
							charge = Math.max(charge, b1.p + b2.p);
						}
					}
				}
				sum += charge;
			} else if (listA.size() == 0) {
				for (Battery b : listB) {
					charge = Math.max(charge, b.p);
				}
				sum += charge;
			} else {
				for (Battery b : listA) {
					charge = Math.max(charge, b.p);
				}
				sum += charge;
			}
		}
	}

	// 거리를 확인
	private static ArrayList<Battery> getAvailableBattery(int x1, int y1) {
		ArrayList<Battery> list = new ArrayList<>();
		for (Battery battery : ap) {
			// 배터리의 유효거리 안에 들어오면 가능
			if (Math.abs(x1 - battery.x) + Math.abs(y1 - battery.y) <= battery.c) {
				list.add(battery);
			}
		}
		return list;
	}
}
