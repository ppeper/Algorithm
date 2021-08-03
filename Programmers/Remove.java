package Programmers;

// 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

import java.util.ArrayList;

class Remove {
    public int[] solution(int[] arr) {
        int small = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length == 1) {
            return new int[]{-1};
        }
        // 촤솟값 찾기
        for (int i : arr) {
            list.add(i);
            small = Math.min(small, i);
        }
        // 최솟값들 삭제
        while(list.contains(small)){
            list.remove((Integer) small);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
