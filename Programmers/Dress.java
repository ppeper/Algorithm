package Programmers;
import java.util.Arrays;

// 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
// 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
// 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
// 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
// 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
// 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
// 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
// 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

class Dress {
    public int solution(int n, int[] lost, int[] reserve) {
        // 현재까지 체육복 입은 학생수
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 자신이 가져온 체육복을 도난당한 학생
        answer += checkSelf(lost,reserve);
        for (int i : lost) {
            if (checkCanBorrow(reserve, i)) {
                answer += 1;
            }
        }
        return answer;
    }

    private int checkSelf(int[] lost, int[] reserve) {
        int check = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    check += 1;
                }
            }
        }
        return check;
    }

    public boolean checkCanBorrow(int[] reserve, int lost) {
        for (int i = 0; i < reserve.length; i++) {
            // 나보다 앞에 사람이 가져왔다면
            if (reserve[i] == lost + 1) {
                reserve[i] = -1;
                return true;
            } else if (reserve[i] == lost - 1) { // 나보다 뒤에 사람이 가져왔다면
                reserve[i] = -1;
                return true;
            }
        }
        return false;
    }
}