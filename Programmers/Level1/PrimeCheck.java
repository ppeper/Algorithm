package Programmers;

class PrimeCheck {
    public int solution(int n) {
        int answer = 0;
        boolean[] numbers = new boolean[n + 1];
        // 0,1은 제외
        numbers[0] = numbers[1] = false;
        for (int i = 2; i <= n; i++) {
            numbers[i] = true;
        }
        // 2~n까지 배수들은 false 할당
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                numbers[j] = false;
            }
        }
        for (int i = 0; i <= n; i++) {
            // true -> 소수
            if (numbers[i]) {
                answer++;
            }
        }
        return answer;
    }
}
