package Programmers.Level2;

// 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
//prices의 길이는 2 이상 100,000 이하입니다.

import java.util.LinkedList;
import java.util.Queue;

class Price {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int price: prices) {
            q.offer(price);
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            int count = 0;
            for (int price: q){
                if (p <= price) {
                    count++;
                } else {
                    count = count == 0 ? 1 : count + 1;
                    break;
                }
            }
            answer[index] = count;
            index++;
        }
        return answer;
    }
}
