package Programmers.level4;

class Thievery {
    public int solution(int[] money) {
        int dp1[] = new int[money.length];
        int dp2[] = new int[money.length];
        for (int i = 0; i < money.length; i++) {
            if (i == 0) {
                dp1[i] = money[i];
                dp2[i] = 0;
            } else if (i == 1) {
                dp1[i] = dp1[i - 1];
                dp2[i] = money[i];
            } else if (i == 2) {
                dp1[i] = dp1[i - 2] + money[i];
                dp2[i] = Math.max(dp2[i - 1], money[i]);
            } else if (i == money.length - 1) {
                dp1[i] = dp1[i - 1];
                dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
            } else {
                dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
                dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
            }
        }
        return Math.max(dp1[money.length - 1], dp2[money.length - 1]);
    }
}
