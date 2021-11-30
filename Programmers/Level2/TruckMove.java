package Programmers.Level2;

// 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
// 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
// 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
//
//예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
// 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Truck {
    private int weight;
    private int position = 0;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPosition() { return position; }

    public void movePosition() { position++; }
}

class TruckMove {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();
        ArrayList<Truck> trucks = new ArrayList<>();
        int time = 0;
        for (int t_weight: truck_weights) {
            queue.offer(new Truck(t_weight));
        }

        while (!queue.isEmpty()) {
            time++;
            // 첫번째 트럭을 가져옴
            Truck truck = queue.peek();
            if (getAllWeight(trucks) + truck.getWeight() <= weight && trucks.size() < bridge_length ) {
                trucks.add(truck);
                queue.poll();
            }
            moveAction(trucks, bridge_length);
        }
        // 다리에 트럭이 남아있다면 가장 마지막에 들어온 트럭이 나갈때까지의 시간을 추가
        time += bridge_length - trucks.get(trucks.size() - 1).getPosition() + 1;

        return time;
    }

    private int getAllWeight(ArrayList<Truck> trucks) {
        int weight = 0;
        for (Truck t: trucks) {
            weight += t.getWeight();
        }
        return weight;
    }

    // 다리에 있는 트럭들이 이동후 지나간 트럭들은 삭제
    private void moveAction(ArrayList<Truck> trucks, int bridge_length) {
        for (int i = 0; i < trucks.size(); i++) {
            // 트럭의 이동
            Truck truck = trucks.get(i);
            truck.movePosition();
            // 이동후 다리를 지나가면 삭제
            if (bridge_length == truck.getPosition()) {
                trucks.remove(i);
                i--;
            }
        }
    }
}
