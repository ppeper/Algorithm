package Programmers;
// 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
// 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
// 각 단어의 짝수번째 알파벳은 대문자로,
// 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수,
// solution을 완성하세요.

class ChangeString {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // 빈칸을 기준으로 단어를 나눈다
        String[] words = s.split(" ", -1);
        for (int i = 0; i < words.length; i++) {
            // 단어별로 살펴본다
            for (int j = 0; j < words[i].length(); j++) {
                if (j % 2 == 0) {
                    answer.append(words[i].substring(j, j + 1).toUpperCase());
                } else {
                    answer.append(words[i].substring(j, j + 1).toLowerCase());
                }
            }
            if (!(i == words.length - 1)) {
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}