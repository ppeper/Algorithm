import java.util.HashMap;

// 수많은 마라톤 선수들이 마라톤에 참여하였습니다.
// 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
// 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
// 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String par : participant) {
            if (hashmap.containsKey(par)) {
                hashmap.put(par, hashmap.get(par) + 1);
            } else {
                hashmap.put(par, 1);
            }
        }
        // 마라톤에 통과한 인원 -1
        for (String com : completion) hashmap.put(com, hashmap.get(com) - 1);
        for (String result : participant) {
            if (hashmap.get(result) != 0){
                answer = result;
                break;
            }
        }
        return answer;
    }
}