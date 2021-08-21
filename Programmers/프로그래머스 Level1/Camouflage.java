package Programmers;

import java.util.HashMap;

// 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
//
// 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
//
// 종류	이름
// 얼굴	동그란 안경, 검정 선글라스
// 상의	파란색 티셔츠
// 하의	청바지
// 겉옷	긴 코트
// 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 0, conbine = 1;
        HashMap<String, Integer> spyItem = new HashMap<>();
        // 스파이의 같은옷의 수를 map에 저장
        for (int i = 0; i < clothes.length; i++) {
            spyItem.put(clothes[i][1], spyItem.getOrDefault(clothes[i][1], 0) + 1);
        }
        // 옷을 하나씩만 입을때의 경우의 수
        for (String item : spyItem.keySet()) {
            answer += spyItem.get(item);
        }
        if (spyItem.size() > 1) {
            // 옷의 조합의수 -> (옷별 개수 + 선택안함(1)) 끼리의 곱의 합 - (옷을 아에안입는경우(1))
            for (Integer value : spyItem.values()) {
                conbine *= (value + 1);
            }
            answer = conbine - 1;
        }
        return answer;
    }
}