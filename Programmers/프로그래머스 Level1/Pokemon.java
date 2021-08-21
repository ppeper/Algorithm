package Programmers;

import java.util.HashSet;
import java.util.Set;

class Pokemon {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        // Set으로 중복된 요소 제거
        for(Integer i: nums) {
            set.add(i);
        }
        // 골라야하는 포켓몬의 수
        int many = nums.length/2;

        int answer = 0;
        if(many < set.size()){
            answer = many;
        }
        else{
            answer = set.size();
        }
        return answer;
    }
}