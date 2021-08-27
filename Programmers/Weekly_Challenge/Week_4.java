package Programmers.Weekly_Challenge;

// 개발자가 사용하는 언어와 언어 선호도를 입력하면 그에 맞는 직업군을 추천해주는 알고리즘을 개발하려고 합니다.
//
//아래 표는 5개 직업군 별로 많이 사용하는 5개 언어에 직업군 언어 점수를 부여한 표입니다.
//
//점수	SI	CONTENTS	HARDWARE	PORTAL	GAME
//5	JAVA	JAVASCRIPT	C	JAVA	C++
//4	JAVASCRIPT	JAVA	C++	JAVASCRIPT	C#
//3	SQL	PYTHON	PYTHON	PYTHON	JAVASCRIPT
//2	PYTHON	SQL	JAVA	KOTLIN	C
//1	C#	C++	JAVASCRIPT	PHP	JAVA
//예를 들면, SQL의 SI 직업군 언어 점수는 3점이지만 CONTENTS 직업군 언어 점수는 2점입니다. SQL의 HARDWARE, PORTAL, GAME 직업군 언어 점수는 0점입니다.
//
//직업군 언어 점수를 정리한 문자열 배열 table, 개발자가 사용하는 언어를 담은 문자열 배열 languages,
// 언어 선호도를 담은 정수 배열 preference가 매개변수로 주어집니다. 개발자가 사용하는 언어의 언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군을 return 하도록 solution 함수를 완성해주세요.
// 총합이 같은 직업군이 여러 개일 경우, 이름이 사전 순으로 가장 빠른 직업군을 return 해주세요.

import java.util.HashMap;

class Week_4 {
    public String solution(String[] table, String[] languages, int[] preference) {
        int max = -1;
        HashMap<Integer, String> valueHM = new HashMap<>();
        // table 나누기
        for (String str : table) {
            int key = getResultValue(str, languages, preference);
            String value = str.split(" ")[0];
            // 같은 값이 존재하면 사전순으로 빠른것으로 바꿔준다
            if (valueHM.containsKey(key)) {
                String preKey = valueHM.get(key);
                if (value.compareTo(preKey) < 0) {
                    valueHM.put(key,value);
                }
            } else {
                valueHM.put(key,value);
            }
        }
        // answer 구하기
        for (Integer value : valueHM.keySet()) {
            if (value > max) {
                max = value;
            }
        }
        return valueHM.get(max);
    }
    private int getResultValue(String str, String[] languages, int[] preference ) {
        int value = 0;
        String[] table = str.split(" ");
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < languages.length; j++) {
                if (table[i].equals(languages[j])) {
                    // 점수 더하기 -> 언어 선호도 X 직업군 언어 점수
                    value += preference[j] * (table.length - i);
                }
            }
        }
        return value;
    }
}
