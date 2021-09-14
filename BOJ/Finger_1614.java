package BOJ;

import java.util.Scanner;

// 영식이는 숫자를 셀 때, 왼손을 이용한다. 엄지손가락부터 시작해서 새끼손가락까지 차례대로 하나씩 센다. 그다음에 새끼손가락까지 센 다음에는 반대로 엄지손가락으로 다시 역방향으로 센다. 영식이는 자기가 원하는 숫자가 나올 때 까지 계속해서 이 방법으로 센다. 영식이는 절대 손가락을 건너뛰지 않는다. 예를 들어 숫자 10을 셀 때는, 엄지 → 검지 → 중지 → 약지 → 새끼 → 약지 → 중지 → 검지 → 엄지 → 검지 이렇게 센다.
//
//영식이가 손가락을 하나 다쳤다. 영식이는 오른손으로는 셀 수 없기 때문에, 왼손으로 세야 한다. 다친 손가락을 이용해서 셀 수 있는 횟수가 제한되어 있다.
//
//영식이가 셀 수 있는 최대 숫자를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 영식이가 다친 손가락이 주어진다. 엄지부터 차례대로 1, 2, 3, 4, 5로 번호가 매겨져 있다. 둘째 줄에는 영식이가 다친 손가락으로 몇 번 셀 수 있는지 주어진다. 이 수는 1,000,000,000보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 영식이가 셀 수 있는 수의 최댓값을 출력한다. 만약 시작도 할 수 없으면 0을 출력한다.

class Finger_1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int finger = sc.nextInt();
        long count = sc.nextLong();
        long result = 0;

        // 엄지손가락 -> 한번 순회당 8번씩
        // 짝수 홀수에 따라 더해지는값 계산
        if (finger == 1) {
            result = count * 8;
        } else if (finger == 2) {
            // 검지부터 시작 -> 한번순회 -> 6번씩(홀수만)
            result = ((count / 2) * 8) + (count % 2) * 6 + 1;
        } else if (finger == 3) {
            // 중지부터 시작 -> 한번순회 -> 4번씩(홀수만)
            result = ((count / 2) * 8) + (count % 2) * 4 + 2;
        } else if (finger == 4) {
            // 약지부터 시작 -> 한번순회 -> 2번씩(홀수만)
            result = ((count / 2) * 8) + (count % 2) * 2 + 3;
        } else  {
            result = count * 8 + 4;
        }
        // 최대로 셀수 있는수 출력
        System.out.println(result);
    }
}