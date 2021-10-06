package Programmers.Weekly_Challenge;

// n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
// 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
// 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
//송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
// 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.

import java.util.ArrayList;

class Week_9 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            answer = Math.min(answer, check(i, wires));
        }
        return answer;
    }

    private int check(int index, int[][] wires) {
        boolean[] bool = new boolean[wires.length];
        for (boolean b : bool) {
            b = false;
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(wires[index][0]);
        arr2.add(wires[index][1]);
        bool[index] = true;
        do {
            for (int i = 0; i < wires.length; i++) {
                // 선을 끊은곳은 패스
                if (index != i) {
                    // 값 존재확인
                    int[] arr = wires[i];
                    // 트리에 포함되면
                    if (arr1.contains(arr[0]) && !bool[i]) {
                        arr1.add(arr[1]);
                        bool[i] = true;
                    } else if (arr1.contains(arr[1]) && !bool[i]) {
                        arr1.add(arr[0]);
                        bool[i] = true;
                    } else if (arr2.contains(arr[0]) && !bool[i]) {
                        arr2.add(arr[1]);
                        bool[i] = true;
                    } else if (arr2.contains(arr[1]) && !bool[i]) {
                        arr2.add(arr[0]);
                        bool[i] = true;
                    }
                }
            }
        } while (!checkFinish(bool));
        return Math.abs(arr1.size() - arr2.size());
    }

    private boolean checkFinish(boolean[] bool) {
        for (boolean b : bool) {
            if (!b) return false;
        }
        return true;
    }
}
