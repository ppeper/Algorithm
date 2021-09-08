// 전화번호부에 적힌 전화번호 중,
// 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
// 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
//      구조대 : 119
//      박준영 : 97 674 223
//      지영석 : 11 9552 4421
// 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이
// solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false
// 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
package Programmers;
import java.util.HashMap;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> pNumbers = new HashMap<>();
        for (String ph : phone_book) {
            pNumbers.put(ph, ph.length());
        }
        for (String ph : pNumbers.keySet()) {
            for (int i = 1; i < pNumbers.get(ph); i++) {
                if (pNumbers.containsKey(ph.substring(0,i))) return false;
            }
        }
        return true;
    }
}