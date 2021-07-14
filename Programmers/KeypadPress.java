package Programmers;
// 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
// 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며,
// 엄지손가락을 사용하는 규칙은 다음과 같습니다.
//       1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
//       2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
//       3.  오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
//       4.  가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
//           4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

class KeypadPress {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        // 각 시작점 *,#을 10,12로 초기화
        int Lhand = 10, Rhand = 12;
        for (int number : numbers) {
            // 왼손으로 입력
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                Lhand = number; // 왼손위치 재설정
                // 오른손으로 입력
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                // 오른손위치 재설정
                Rhand = number;
            } else {
                if (number == 0) {
                    number = 11;    // 0을 11로 바꿈
                }
                int left = Math.abs(Lhand - number);
                int right = Math.abs(Rhand - number);
                // 거리비교
                if (distance(left) > distance(right)) {
                    answer.append("R");
                    Rhand = number;
                } else if (distance(left) == distance(right)) {
                    if (hand.equals("right")) {
                        answer.append("R");
                        Rhand = number;
                    } else {
                        answer.append("L");
                        Lhand = number;
                    }
                } else {
                    answer.append("L");
                    Lhand = number;
                }
            }
        }
        return answer.toString();
    }

    public int distance(int hand) {
        // 0이면 0칸
        if (hand == 0) hand = 0;
        // 1, 3이면 한칸거리
        else if (hand == 1 || hand == 3) hand = 1;
        // 2, 4, 6이면 2칸거리
        else if (hand == 2 || hand == 4 || hand == 6) hand = 2;
        // 5, 7, 9면 3칸거리
        else if (hand == 5 || hand == 7 || hand == 9) hand = 3;
        else hand = 4;
        return hand;
    }
}