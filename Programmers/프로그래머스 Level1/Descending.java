package Programmers;

import java.util.Arrays;

class Descending {
    public long solution(long n) {
        String number = Long.toString(n);
        StringBuilder s = new StringBuilder();
        char[] chars = number.toCharArray();
        Arrays.sort(chars);
        for (char c : chars) {
            s.append(c);
        }
        return Long.parseLong(s.reverse().toString());
    }
}
