package Programmers.Level2;

// 데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
//간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다. "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
//
//예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.
//
//다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.
//
//압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

class Compression {
    public int solution(String s) {
        // 처음은 최대길이로 초기화
        int answer = s.length();
        // 절반이상부턴 나눌수 있는 의미가 없다
        int limit = s.length() / 2;
        for (int i = 1; i <= limit; i++) {
            answer = Math.min(answer, afterCompression(s, i));
        }
        return answer;
    }
    private int afterCompression(String s, int unit) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        String curr = "";
        for (int i = 0; i < s.length(); i+=unit) {
            String sub = s.substring(i, i + unit);
            // 처음시작
            if (curr.equals("")) {
                curr = sub;
                continue;
            }

            // 남은 문자열이 더 짧다면
            if (i + unit > s.length()) {
                if (count == 1) {
                    output.append(curr);
                } else {
                    output.append(count).append(curr);
                }
                // 마지막으로 붙여준다.
                output.append(s.substring(i));
            } else {
                // 전에 짤랐던 문자열과 같다면 compress
                if (curr.equals(sub)) {
                    count += 1;
                } else {
                    // 전에 나왔던 문자열은 한번만 반복
                    if (count == 1) {
                        output.append(curr);
                    } else {
                        // 몇번 반복되어 압축되었는지 같이 저장
                        output.append(count).append(curr);
                        // coubnt 초기화
                        count = 1;
                    }
                    // curr를 지금 자른 문자열로 바꿔줌
                    curr = sub;
                }
                // 마지막 문자열까지 확인 완료
                if (i + unit == s.length()) {
                    if (count == 1) {
                        output.append(curr);
                    } else {
                        output.append(count).append(curr);
                    }
                }
            }
        }
        return output.length();
    }
}
