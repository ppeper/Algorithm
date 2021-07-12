package Programmers;

import java.util.ArrayList;
import java.util.List;

class Kth_Numbers {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> arr = new ArrayList<Integer>();
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int [] op = commands[i];
            // 문자열 잘라내기
            for (int j = op[0]-1; j < op[1]; j++) {
                arr.add(array[j]);
            }
            arr.sort(null);
            answer[i] = arr.get(op[2]-1);
            arr.removeAll(arr);
        }
        return answer;
    }
}