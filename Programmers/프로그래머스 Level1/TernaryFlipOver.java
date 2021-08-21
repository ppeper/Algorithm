package Programmers;
//자연수 n이 매개변수로 주어집니다.
// n을 3진법 상에서 앞뒤로 뒤집은 후, 이
// 를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

class TernaryFlipOver {
    public int solution(int n) {
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            // 3진법으로 나타내기 위해 나머지를 더해준다
            str.append(n % 3);
            // 몫으로 n을 변경
            n /= 3;
        }
        str.reverse();
        // 3진법을 10진법으로 변경
        int answer = Integer.parseInt(String.valueOf(str.reverse()), 3);

        return answer;
    }

    public static void main(String[] args) {
        TernaryFlipOver t = new TernaryFlipOver();
        System.out.println(t.solution(45));
    }
}
