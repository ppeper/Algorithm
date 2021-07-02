// 1 ~45까지의 숫자중 6개를 찍어서 맞히는 대표적인 복권이다.
//        1	6개 번호가 모두 일치
//        2	5개 번호가 일치
//        3	4개 번호가 일치
//        4	3개 번호가 일치
//        5	2개 번호가 일치
//        6(낙첨)	그 외
// 최대 당첨 등수와 최소 당첨 등수를 구하라
public class Lottos {
    public int[] solution(int[] lottos, int[] win_nums) {
        int length = lottos.length;
        int j = 0;
        int [] answer = new int[2];
        int highScore = 0, lowScore = 0;
        int countZero = 0;
        for (int check : lottos) {
            if (check == 0) countZero++;
        }
        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    highScore += 1;
                    lowScore += 1;
                }
            }
        }
        answer[0] = checkRank(highScore + countZero);
        answer[1] = checkRank(lowScore);

        return answer;
    }
    // 맞춘 개수만큼 등수
    public int checkRank(int number) {
        switch (number) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
