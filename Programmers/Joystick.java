package Programmers;

import java.util.HashMap;

class Joystick {
    public int solution(String name) {
        int answer = 0,countFront = 0,countEnd = 0;
        HashMap<Character, Integer> move = new HashMap<>();
        addMap(move);
        for (int i = 0; i < name.length(); i++) {
            answer += move.get(name.charAt(i));
        }
        answer += name.length() - 1; // move 연산횟수
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) == 'A') countFront++;
            else break;
        }
        for (int i = name.length() - 1; i > 0; i--) {
            if (name.charAt(i) == 'A') countEnd++;
            else break;
        }
        int end = 0, countA = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                countA++;
            } else {
                end = i;
                break;
            }
        }
        int start = countA - end;
        int temp = Math.min(answer - countFront, answer - countEnd);
        int moveMiddle = (start * 2) + (name.length() - 1 - end);


        return answer;
    }

    public void addMap(HashMap<Character, Integer> hm) {
        int j=0;
        for (char i='A'; i<='N'; i++){
            hm.put(i, j);
            j++;
        }
        j=1;
        for (char i='Z'; i>='O'; i--){
            hm.put(i, j);
            j++;
        }
    }
}