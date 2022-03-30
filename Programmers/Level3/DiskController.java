package Programmers.Level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController{
    public int solution(int[][] jobs) {
        // 들어온 시간 순서로 정렬(오름차순)
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 작업의 시간이 가장 적게 걸리는 순으로 정렬
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int answer = 0;
        int time = 0;
        int index = 0;
        while (!heap.isEmpty() || index < jobs.length) {
            // 디스크에서 작업이 가능한 job을 다 넣어줌
            while (index < jobs.length && time >= jobs[index][0]) {
                heap.add(jobs[index++]);
            }

            if (heap.isEmpty()) {
                // 시작시간으로 초기화화
               time = jobs[index][0];
            } else {
                int[] job = heap.poll();
                answer += time - job[0] + job[1];
                time += job[1];
            }
        }
        return answer / jobs.length;
    }
}
