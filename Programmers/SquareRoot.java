package Programmers;

class SquareRoot {
    public long solution(long n) {
        long number = (long) Math.sqrt(n);
        // number의 제곱이 n과 같을때
        if (Math.pow(number, 2) == n) {
            return (long) Math.pow(number + 1, 2);
        } else {
            return -1;
        }
    }
}
