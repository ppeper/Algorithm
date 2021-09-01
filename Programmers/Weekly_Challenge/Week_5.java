package Programmers.Weekly_Challenge;

// 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
//
// 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
//
// 제한사항
// word의 길이는 1 이상 5 이하입니다.
// word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.

import java.util.HashMap;

class Week_5 {
    public int solution(String word) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A", 1);
        hm.put("E", 2);
        hm.put("I", 3);
        hm.put("O", 4);
        hm.put("U", 5);
        int answer = 0;
        String[] wordSplit = word.split("");
        // 각자리 수마다가 지나간 횟수를 더함
        for (int i = 0; i < wordSplit.length; i++) {
            // 반대의 자리수
            int digit = hm.size() - i - 1;
            int multi = hm.get(wordSplit[i]) - hm.get("A");
            answer += multi * getPass(digit) + hm.get(wordSplit[i]);
        }
        return answer;
    }

    private int getPass(int digit) {
        int pass = 0;
        for (int i=1; i<= digit; i++) {
            pass += Math.pow(5, i);
        }
        return pass;
    }
}
