package Programmers;
// 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
// 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
// 이중 가장 큰 수는 6210입니다.
// 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
// 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

import java.util.*;

class MaxNumber {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> list = new ArrayList<String>();
        for (int i : numbers) {
            list.add(String.valueOf(i));
        }
        // 가장 크게 만들수 있게 정렬
        // o2 + o1 이 더크면 -> 더크게만들수있음 -> 위치를 바꿔서 정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
            }
        });

        for (String s : list) {
            answer.append(s);
        }

        // 만들어진 최대정수 문자열이 0으로 시작할때
        if (answer.toString().startsWith("0")) {
            return "0";
        } else {
            return answer.toString();
        }
    }
}
