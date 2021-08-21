package Programmers;

import java.util.*;

class Addnumber {
    public int[] solution(int[] numbers) {
        int add = 0;
        // 중복요소 거르기 위하여 Set 사용
        Set<Integer> addSet = new HashSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                add = numbers[i] + numbers[j];
                addSet.add(add);
            }
        }
        List<Integer> list = new ArrayList<>(addSet);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
