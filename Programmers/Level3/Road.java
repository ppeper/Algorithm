package Programmers.Level3;

class Road {
    static int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] road = new int[n][m];
        // 물웅덩이
        for (int[] puddle: puddles) {
            road[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        // 기본 갈수 있는 값 세팅
        for (int i = 0; i < n; i++) {
            if (road[i][0] != -1) {
                road[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (road[0][i] != -1) {
                road[0][i] = 1;
            } else {
                break;
            }
        }
        // 갈 수 있는 경로 확인
        for (int x = 1; x < road.length; x++) {
            for (int y = 1; y < road[x].length; y++) {
                // 물웅덩이 X
                if (road[x][y] != -1) {
                    // 위, 옆이 다 물웅덩이가 아니라면
                    if (road[x - 1][y] != -1 && road[x][y - 1] != -1) {
                        road[x][y] += road[x][y - 1] + road[x - 1][y];
                    } else {
                        if (road[x][y - 1] == -1) {
                            road[x][y] += road[x - 1][y];
                        } else {
                            road[x][y] += road[x][y - 1];
                        }
                    }
                }
                if (road[x][y] > MOD) {
                    road[x][y] %= MOD;
                }
            }
        }
        return road[n - 1][m - 1];
    }
}
