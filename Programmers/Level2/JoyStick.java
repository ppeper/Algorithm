package Programmers.Level2;

import java.util.HashMap;

// 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
//ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
//
//조이스틱을 각 방향으로 움직이면 아래와 같습니다.
//
//▲ - 다음 알파벳
//▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
//◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
//▶ - 커서를 오른쪽으로 이동
//예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
//
//- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
//- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
//- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
//따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
//만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
//
//제한 사항
//name은 알파벳 대문자로만 이루어져 있습니다.
//name의 길이는 1 이상 20 이하입니다.

class JoyStick {
    public int solution(String name) {
        int answer = 0;
        int cursor = 0;
        HashMap<Character, Integer> move = new HashMap<>();
        addMap(move);
        StringBuilder init = new StringBuilder();
        // 초기 문자 "A" * name의 길이만큼 설정
        init.append("A".repeat(name.length()));

        // 바꿔야할 문자까지의 앞으로거리 front
        while (true) {
            // 문자 바꾸는 비용
            answer += move.get(name.charAt(cursor));
            // name의 문자로 cursor 위치 초기값 변경
            init.replace(cursor, cursor + 1, String.valueOf(name.charAt(cursor)));
            // 바꾼후 init 문자가 name으로 변경 완료면 break
            if (init.toString().equals(name)) break;
            int front = getFrontDistance(name, cursor, init);
            int back = getBackDistance(name, cursor, init);

            // 같거나 front가 더 짧으면 커서 앞으로 이동
            if (front <= back) {
                cursor++;
                answer++;
            } else {
                // back이 더 짧다면 다시 -> 로 맨앞으로 못돌아 오기때문에 계산후 닶 리턴
                answer += back; // 커서 이동 비용
                for (int i = cursor + 1; i < name.length(); i++) {
                    // 문자 바꾸는 비용
                    answer += move.get(name.charAt(i));
                }
                return answer;
            }
        }
        return answer;
    }

    private void addMap(HashMap<Character, Integer> hm) {
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

    private int getFrontDistance(String name, int cursor, StringBuilder input) {
        StringBuilder init = new StringBuilder(input);
        int front = 0;
        // cursor의 다음부터 확인 -> 마지막으로 바꿔야할 위치까지 거리
        for (int i = cursor; i < name.length(); i++) {
            // 둘이 다르면 문자변경
            if (init.charAt(i) != name.charAt(i)) {
                init.replace(i, i + 1, String.valueOf(name.charAt(i)));
            }
            // 변경후 같으면 stop
            if (name.equals(init.toString())) break;

            front++;
        }
        return front;
    }

    private int getBackDistance(String name, int cursor, StringBuilder input) {
        StringBuilder init = new StringBuilder(input);
        int back = cursor; // 마지막까지 <- 갈때의 비용
        for (int i = name.length() - 1; i > cursor; i--) {
            if (name.equals(init.toString())) break;

            // 둘이 다르면 문자변경
            if (init.charAt(i) != name.charAt(i)) {
                init.replace(i, i + 1, String.valueOf(name.charAt(i)));
            }
            back++;
        }
        return back;
    }
}
