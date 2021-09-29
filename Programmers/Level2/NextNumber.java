package Programmers.Level2;

//자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//
//조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//
//자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

class NextNumber {
    public int solution(int n) {
        int answer = 0;
        int countN = getCountOne(n);
        while (true) {
            int check = n+=1;
            if (countN == getCountOne(check)) {
                answer = check;
                break;
            }
        }
        return answer;
    }

    private int getCountOne(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }
}
