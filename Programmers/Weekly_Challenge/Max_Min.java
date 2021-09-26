package Programmers.Weekly_Challenge;

// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
//예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

import java.util.Arrays;

class Max_Min {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        int[] number = new int[split.length];
        for (int i=0; i<split.length; i++) {
            number[i] = Integer.parseInt(split[i]);
        }
        // 오름차순 정렬
        Arrays.sort(number);
        answer = number[0] + " " + number[number.length-1];
        return answer;
    }
}
