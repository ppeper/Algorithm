package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return answer += 5 * cities.length;
        }
        Queue<String> LRU = new LinkedList<>();
        for (String str : cities) {
            String city = str.toUpperCase();
            if (LRU.isEmpty()) {
                LRU.offer(city);
                answer += 5;
            } else {
                // cache hit!
                if (checkCache(LRU, city)) {
                    answer += 1;
                    LRU.remove(city);
                    LRU.offer(city);
                } else { // cache miss!
                    if (LRU.size() == cacheSize) {
                        LRU.poll();
                    }
                    LRU.offer(city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
    // 캐쉬에 해당 도시가 있으면 true
    private boolean checkCache(Queue<String> LRU, String city) {
        return LRU.contains(city);
    }
}
