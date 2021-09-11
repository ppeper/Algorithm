package Programmers.Weekly_Challenge;

import java.util.*;

// 복서 선수들의 몸무게 weights와, 복서 선수들의 전적을 나타내는 head2head가 매개변수로 주어집니다. 복서 선수들의 번호를 다음과 같은 순서로 정렬한 후 return 하도록 solution 함수를 완성해주세요.
//
//전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
//승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
//자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
//자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
//제한사항
//weights의 길이는 2 이상 1,000 이하입니다.
//weights의 모든 값은 45 이상 150 이하의 정수입니다.
//weights[i] 는 i+1번 복서의 몸무게(kg)를 의미합니다.
//head2head의 길이는 weights의 길이와 같습니다.
//head2head의 모든 문자열은 길이가 weights의 길이와 동일하며, 'N', 'W', 'L'로 이루어진 문자열입니다.
//head2head[i] 는 i+1번 복서의 전적을 의미하며, head2head[i][j]는 i+1번 복서와 j+1번 복서의 매치 결과를 의미합니다.
//'N' (None)은 두 복서가 아직 붙어본 적이 없음을 의미합니다.
//'W' (Win)는 i+1번 복서가 j+1번 복서를 이겼음을 의미합니다.
//'L' (Lose)는 i+1번 복사가 j+1번 복서에게 졌음을 의미합니다.
//임의의 i에 대해서 head2head[i][i] 는 항상 'N'입니다. 자기 자신과 싸울 수는 없기 때문입니다.
//임의의 i, j에 대해서 head2head[i][j] = 'W' 이면, head2head[j][i] = 'L'입니다.
//임의의 i, j에 대해서 head2head[i][j] = 'L' 이면, head2head[j][i] = 'W'입니다.
//임의의 i, j에 대해서 head2head[i][j] = 'N' 이면, head2head[j][i] = 'N'입니다.
class GameRecord {
    int player, weight, winOverWeight;
    double winRate;

    GameRecord(int player, int weight, int winOverWeight, double winRate) {
        this.player = player;
        this.weight = weight;
        this.winOverWeight = winOverWeight;
        this.winRate = winRate;
    }
    public int getPlayer() {
        return player;
    }
}
class Week_6 {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<GameRecord> games = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            int player = i + 1;
            int weight = weights[i];
            int win = 0;
            int winOverWeight = 0;
            int totalGame = 0;
            String[] result = head2head[i].split("");
            // 한사람의 경기 내용
            for (int j = 0; j < result.length; j++) {
                if (result[j].equals("W")) {
                    // 나보다 체중이나가는 사람을 이김
                    if (weights[j] > weight) {
                        winOverWeight++;
                    }
                    win++;
                    totalGame++;
                } else if (result[j].equals("L")) {
                    totalGame++;
                }
            }
            double winRate;
            if (totalGame == 0) {
                winRate = 0.0;
            } else {
                winRate = ((double) win / totalGame);
            }
            games.add(new GameRecord(player, weight, winOverWeight, winRate));
        }
        games.sort(new Comparator<GameRecord>() {
            // 1. 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
            // 2. 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
            // 3. 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
            // 4. 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
            @Override
            public int compare(GameRecord o1, GameRecord o2) {
                if (o1.winRate > o2.winRate) {
                    return -1;
                } else if (o1.winRate == o2.winRate) {
                    // 2번
                    if (o1.winOverWeight > o2.winOverWeight) {
                        return -1;
                    } else if (o1.winOverWeight == o2.winOverWeight) {
                        // 3번
                        if (o1.weight > o2.weight) {
                            return -1;
                        } else if (o1.weight == o2.weight) {
                            // 4번
                            return o1.player - o2.player;
                        } else {
                            return 1;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < answer.length; i++) {
            answer[i] = games.get(i).getPlayer();
        }
        return answer;
    }
}
