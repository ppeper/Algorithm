package Programmers.Level3;

// 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//
//속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//genres[i]는 고유번호가 i인 노래의 장르입니다.
//plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
//genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
//장르 종류는 100개 미만입니다.
//장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
//모든 장르는 재생된 횟수가 다릅니다.
import java.util.*;

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        HashMap<String, Integer> setAllPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            setAllPlays.put(genres[i], setAllPlays.getOrDefault(genres[i], 0) + plays[i]);
            if (!hm.containsKey(genres[i])) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(plays[i]);
                hm.put(genres[i], list);
            } else {
                hm.get(genres[i]).add(plays[i]); // 해당하는 장르가 있다면 play만 추가
                // 내림차순 정렬
                hm.get(genres[i]).sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
            }
        }
        // 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(setAllPlays.entrySet());
        entryList.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // 값 구하기
        for (Map.Entry<String, Integer> entry : entryList) {
            int i = 0;
            int prev = 0;
            for (int value : hm.get(entry.getKey())) {
                int index = getIndex(plays, value, prev);
                answer.add(index);
                prev = value;
                i++;
                if (i == 2) {
                    break;
                }
            }
        }
        int[] answerToList = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerToList[i] = answer.get(i);
        }
        return answerToList;
    }

    private int getIndex(int[] plays, int value, int prev) {
        boolean check = false;
        for (int i = 0; i < plays.length; i++) {
            if (plays[i] == value) {
                // 이전의 play가 이미 저장이면 다음 같은값의 play index위치로 가야한다
                if (prev == value && !check) {
                    check = true;
                    continue;
                }
                return i;
            }
        }
        return 0;
    }
}
