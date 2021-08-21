package Programmers;

// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
// 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

class Reverse {
    public int[] solution(long n) {
        // n의 자리수 만큼 크기설정
        int[] answer = new int[(int) Math.log10(n) + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
}
