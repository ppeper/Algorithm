package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수,
// solution을 완성해주세요. s는 영문 대소문자로만 구성되어 있으며,
// 대문자는 소문자보다 작은 것으로 간주합니다.

class DecendingString {
    public String solution(String s) {
        List<String> upper = new ArrayList<>();
        List<String> lower = new ArrayList<>();
        for (char a: s.toCharArray()) {
            if (97 <= a && a <= 122) {
                lower.add(a + "");
            } else {
                upper.add(a + "");
            }
        }
        // 내림차순으로 정렬
        upper.sort(Comparator.reverseOrder());
        lower.sort(Comparator.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (String str : lower) {
            answer.append(str);
        }
        for (String str : upper) {
            answer.append(str);
        }
        return answer.toString();
    }
}
