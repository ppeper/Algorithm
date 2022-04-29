package Programmers.Level3;

import java.util.Arrays;
import java.util.Comparator;

class Camera {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 가장 처음 들어왔다 나가는 차량의 마지막에 카메라를 하나 위치한다
        int camera = routes[0][1];
        int answer = 1;
        // 차량의 개수만큼 체크가 되어야한다.
        for (int i = 0; i < routes.length - 1; i++) {
            int[] start_car = routes[i];
            // 다음 차량
            int[] next_car = routes[i + 1];
            // 이전 카메라가 현재 차량이 나가는 시점보다 멀다면 앞으로 땡겨서 겹치게 해준다
            if (start_car[1] < camera) {
                camera = start_car[1];
            }
            // 시작 차량이 끝나는 지점(camera)보다 다음 차량이 진입하는 시점이 더 크면 -> 그냥 카메라가 하나 필요 (겹칠 수 없음)
            if (camera < next_car[0]) {
                // 카메라 하나 더 추가
                camera = next_car[1];
                answer++;
            }
        }
        return answer;
    }
}
