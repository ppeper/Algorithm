package Programmers;

// 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

class Fibo {
    public int solution(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;

        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i-1] % 1234567 + nums[i-2] % 1234567;
        }
        return nums[n] % 1234567;
    }
}
