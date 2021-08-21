package Programmers;

import java.util.*;

class MenuRenewal {
    public void solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        List<String> makecourse = new ArrayList<>();
        HashMap<String, Integer> menu_count = new HashMap<>();
        // 해쉬맵에 매뉴별 개수를 저장
        for (String str : orders) {
            String[] split = str.split("");
            for (String menu : split) {
                menu_count.put(menu, menu_count.getOrDefault(menu, 0) + 1);
            }
        }
        // 주문이 1번 -> 삭제
        for (String key : menu_count.keySet()) {
            if (menu_count.get(key) == 1) {
                menu_count.remove(key);
            }
        }
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(menu_count.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if (!o2.getValue().equals(o1.getValue())) {
//                    return o2.getValue() - o1.getValue();
//                } else {
//                    return o1.getKey().compareTo(o2.getKey());
//                }
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println(entryList.toString());
        // course의 개수별 메뉴 설정
            for (Map.Entry<String, Integer> entry : entryList) {

            }
        // 정답에 추가
    }

    public static void main(String[] args) {
        MenuRenewal m = new MenuRenewal();
        String[] orders = {"ABCFG", "AC", "CDE", "ACED", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        m.solution(orders, course);
    }
}