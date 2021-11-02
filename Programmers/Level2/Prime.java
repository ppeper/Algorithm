package Programmers.Level2;

import java.util.HashSet;

// 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
// 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
// numbers는 길이 1 이상 7 이하인 문자열입니다.
// numbers는 0~9까지 숫자만으로 이루어져 있습니다.
// "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
class Prime {
    HashSet<Integer> list;
    boolean[] isChecked;
    public int solution(String numbers) {
        int answer = 0;
        String[] split = numbers.split("");
        isChecked = new boolean[split.length];
        list = new HashSet<>();
        // 만들수있는 숫자 다 탐색
        for (int i=1; i <= split.length; i++) {
            DFS(i, split, 0,"");
        }
        // 소수를 찾아서 answer 값 추가
        for (int value : list) {
            if (checkPrime(value)) {
                answer++;
            }
        }
        return answer;
    }

    private void DFS(int length, String[] split, int depth, String str) {
        if (depth == length) {
            list.add(Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < split.length; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                str += split[i];
                DFS(length, split, depth + 1, str);
                // 붙인값 삭제
                str = str.substring(0, str.length()-1);
                isChecked[i] = false;
            }
        }
    }

    // 소수확인
    private boolean checkPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        if (num == 1) return false;
        else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= sqrt; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }
            // 다 안나눠지면 소수
            return true;
        }
    }
}
