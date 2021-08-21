package Programmers;

import java.util.ArrayList;
import java.util.List;

//개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다
//코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
//아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
//  1. 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
//  2. 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
//  3. 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.

class P {
    int x,y;
    P(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }
}

class KeepDistance {
    public int[] solution(String[][] places) {
        List<P> pList = new ArrayList<>();
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            // i행에 대한 대기방 -> ex) 1번 대기방
            String[][] table = table(pList, i, places);

            if (pList.isEmpty()) { // 대기자가 없는방이라면 룰을 지킴
                answer[i] = 1;
            } else {
                boolean check = true;
                for (int a = 0; a < pList.size(); a++) {
                    for (int b = a + 1; b < pList.size(); b++) {
                        if (manhatten(pList.get(a), pList.get(b)) == 2) {
                            // 맨허튼거리가 2일때 사이의 값에 빈 테이블이 있으면 안됨
                            if (!checkRule(pList.get(a), pList.get(b), table)) {
                                check = false;
                                break;
                            }
                            // 2보다작을때
                        } else if (manhatten(pList.get(a), pList.get(b)) < 2) {
                            check = false;
                            break;
                        }
                    }
                }
                if (check) {
                    answer[i] = 1;
                } else {
                    answer[i] = 0;
                }
            // 다음 대기열을 위해 clear
            pList.clear();
            }
        }
        return answer;
    }

    // 테이블별로 2차원 배열 생성
    // ex) tableNumber = 1 -> 1번 대기방 2차원 배열
    public String[][] table(List<P> p ,int roomNumber, String[][] places) {
        String[][] table = new String[places.length][places.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                String[] split = places[roomNumber][i].split("");
                table[i][j] = split[j];
                // P의 좌표들 저장
                if (split[j].equals("P")) {
                    p.add(new P(i,j));
                }
            }
        }
        return table;
    }

    // 맨허튼 거리구하기
    public int manhatten(P p1, P p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    public boolean checkRule(P a, P b, String[][] table) {
        int x_start = Math.min(a.getX(), b.getX());
        int y_start = Math.min(a.getY(), b.getY());
        int x_end = Math.max(a.getX(), b.getX());
        int y_end = Math.max(a.getY(), b.getY());

        for (int x = x_start; x <= x_end; x++) {
            for (int y = y_start; y <= y_end; y++) {
                // 거리가 2일때 사이에 빈테이블이라면 -> 룰을 지키지 못함
                if (table[x][y].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }
}