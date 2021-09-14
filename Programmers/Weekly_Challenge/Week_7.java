package Programmers.Weekly_Challenge;

// 사회적 거리두기를 위해 회의실에 출입할 때 명부에 이름을 적어야 합니다. 입실과 퇴실이 동시에 이뤄지는 경우는 없으며, 입실 시각과 퇴실 시각은 따로 기록하지 않습니다.
//
//오늘 회의실에는 총 n명이 입실 후 퇴실했습니다. 편의상 사람들은 1부터 n까지 번호가 하나씩 붙어있으며, 두 번 이상 회의실에 들어온 사람은 없습니다. 이때, 각 사람별로 반드시 만난 사람은 몇 명인지 구하려 합니다.
//
//예를 들어 입실 명부에 기재된 순서가 [1, 3, 2], 퇴실 명부에 기재된 순서가 [1, 2, 3]인 경우,
//
//1번과 2번은 만났는지 알 수 없습니다.
//1번과 3번은 만났는지 알 수 없습니다.
//2번과 3번은 반드시 만났습니다.
//또 다른 예로 입실 순서가 [1, 4, 2, 3], 퇴실 순서가 [2, 1, 3, 4]인 경우,
//
//1번과 2번은 반드시 만났습니다.
//1번과 3번은 만났는지 알 수 없습니다.
//1번과 4번은 반드시 만났습니다.
//2번과 3번은 만났는지 알 수 없습니다.
//2번과 4번은 반드시 만났습니다.
//3번과 4번은 반드시 만났습니다.
//회의실에 입실한 순서가 담긴 정수 배열 enter, 퇴실한 순서가 담긴 정수 배열 leave가 매개변수로 주어질 때, 각 사람별로 반드시 만난 사람은 몇 명인지 번호 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

import java.util.*;

class Week_7 {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Stack<Integer> roomInfo = new Stack<>();
        Queue<Integer> leaveInfo = new LinkedList<>();
        for (int l : leave) {
            leaveInfo.offer(l);
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : enter) {
            // 아무도 방에 미리없으면 만난인원 0
            if (roomInfo.isEmpty()) {
                map.put(j, 0);
            } else {
                // 지금들어올 인원과 이미 방에인원들은 다 만남
                for (int user : roomInfo) {
                    map.put(user, map.getOrDefault(user, 1) + 1);
                }
                //지금 들어온 인원은 지금 방에있는 인원수만큼 더해준다.
                map.put(j, roomInfo.size());
            }
            // 방에 입장.
            roomInfo.push(j);

            // 방의 마지막 입장자와 처음으로 나가는인원이 같을때
            if (roomInfo.peek().equals(leaveInfo.peek())) {
                roomInfo.pop();
                leaveInfo.poll();
                // 방에 나가는 인원이 존재하면 다 나간다 -> 꼭 만나는 인원들만 골라내기위해 다음 인원이 들어오기전에 나간다.
                while (!roomInfo.isEmpty()) {
                    if (roomInfo.contains(leaveInfo.peek())) {
                        roomInfo.remove(leaveInfo.peek());
                        leaveInfo.poll();
                    } else {
                        break;
                    }
                }
            }
        }
        // 오름차순 정렬
        Arrays.sort(enter);
        for (int i = 0; i < enter.length; i++) {
            answer[i] = map.get(enter[i]);
        }
        return answer;
    }
}
