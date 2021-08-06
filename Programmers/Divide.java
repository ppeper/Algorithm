package Programmers;

// array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
//divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

import java.util.Collections;
import java.util.Vector;

class Divide {
    public int[] solution(int[] arr, int divisor) {
        Vector<Integer> v = new Vector<Integer>();
        for (int value : arr) {
            if (value % divisor == 0) {
                v.add(value);
            }
        }
        if (v.size() == 0) return new int[]{-1};
        // 오름차순으로 정렬
        Collections.sort(v);
        int[] answer = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            answer[i] = v.get(i);
        }
        return answer;
    }
}
