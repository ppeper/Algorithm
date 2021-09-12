package Programmers.Level2;

// 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
//기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
//단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
//
//예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
//(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
//
//손님 번호	주문한 단품메뉴 조합
//1번 손님	A, B, C, F, G
//2번 손님	A, C
//3번 손님	C, D, E
//4번 손님	A, C, D, E
//5번 손님	B, C, F, G
//6번 손님	A, C, D, E, H
//가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.
//
//코스 종류	메뉴 구성	설명
//요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
//요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
//요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
//요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
//[문제]
//각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

import java.util.*;

class MenuRenewal {
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> menuReOrder = new ArrayList<>();
        // 각 요리코스가 나온 개수 저장
        HashMap<String, Integer> menuCount = new HashMap<>();

        // 만들수있는 메뉴를 다만들어준다.
        for (String order : orders) {
            String[] split = order.split("");
            // 알파벳순으로 정렬
            Arrays.sort(split);
            for (int i = 0; i < split.length; i++) {
                for (int cour : course) {
                    getRemenuOrder(split[i], split, menuCount ,1, cour, i + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(menuCount.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 내림차순 정렬
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> str: list) {
            for (int cour : course) {
                int getMax = getMaxOrder(list, cour);
                if (getMax != 0) {
                    if (str.getKey().length() == cour) {
                        if (str.getValue() == getMax) {
                            menuReOrder.add(str.getKey());
                        }
                    }
                }
            }
        }
        String[] answer = menuReOrder.toArray(new String[0]);
        Arrays.sort(answer);

        return answer;
    }

    private int getMaxOrder(List<Map.Entry<String, Integer>> list, int cour) {
        for (Map.Entry<String, Integer> str: list ) {
            // 내림차순 정렬 -> 가장처음 나오는것이 가장 많이 선택된 메뉴구성
            if (str.getKey().length() == cour) {
                // 선택한 코스메뉴가 최대 1명만 선택했으면 메뉴구성에서 제외
                return (str.getValue() == 1) ? 0 : str.getValue();
            }
        }
        return 0;
    }

    private void getRemenuOrder(String menu, String[] split, HashMap<String, Integer> menuCount, int depth, int length, int start) {
        if (depth == length) {
            menuCount.put(menu, menuCount.getOrDefault(menu, 0) + 1);
            return;
        }
        for (int j = start; j < split.length; j++) {
            getRemenuOrder(menu + split[j],split, menuCount,depth+1, length, j + 1);
        }
    }
}
