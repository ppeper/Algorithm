package Programmers.Level3;


class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        // 두번째 부터 확인
        for (int i = 1; i< triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 처음값은 왼쪽만
                if (j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == triangle[i].length - 1) {   // 마지막 값은 오른쪽만
                    triangle[i][j] += triangle[i][j];
                } else { // 둘의 비교
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        for (int number: triangle[triangle.length -1]) {
            answer = Math.max(answer, number);
        }
        return answer;
    }
}
