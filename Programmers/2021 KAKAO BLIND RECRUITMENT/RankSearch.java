package Programmers.Level2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class RankSearch {
    HashMap<String, ArrayList<Integer>> allInfoValue = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        // 모든 경우의 key값을 구한다.
        for (String str : info) {
            DFS("", 0, str.split(" "));
            // 해당 사용자 정보에 대한 map이 완료되면 점수를 오름차순으로 정렬해 준다.
        }
        // 해당 key값에 대한 점수를 오름차순으로 모두 정렬한다.
        ArrayList<String> keys = new ArrayList<String>(allInfoValue.keySet());
        for (String str: keys) {
            Collections.sort(allInfoValue.get(str));
        }

        // 원하는 값 구하기
        for (int i = 0; i < query.length; i++) {
            // java and backend and junior and pizza 100 -> javabackendjuniorpizza 100
            String replace = query[i].replaceAll(" and ", "");
            String[] str = replace.split(" ");
            answer[i] = searchValue(str[0], Integer.parseInt(str[1]));
        }
        return answer;
    }

    // 모든 나올수 있는 조합을 뽑아서 List에 넣는다
    private void DFS(String str, int depth, String[] info) {
        if (depth == 4) {
            // 해당 조합의 사용자 정보가 저장 안되어있다면
            if (!allInfoValue.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<>();
                // 점수 저장
                list.add(Integer.parseInt(info[4]));
                allInfoValue.put(str, list);
            } else {
                // 해당 조합의 사용자 전보가 저장되어 있으면 -> list를 가져와서 해당 점수만 추가
                allInfoValue.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }
        DFS(str + "-", depth + 1, info);
        DFS(str + info[depth], depth + 1, info);
    }

    // 이진탐색을 사용하여 answer을 구해준다.
    private int searchValue(String query, int score) {
        // 해당하는 질의에 만족하지 않으면
        if (!allInfoValue.containsKey(query)) {
            return 0;
        } else {
            ArrayList<Integer> value = allInfoValue.get(query);
            int start = 0, end = value.size() - 1;
            // 이진탐색
            while (start <= end) {
                int mid = (start + end) / 2;
                if (value.get(mid) < score) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return value.size() - start;
        }
    }
}
