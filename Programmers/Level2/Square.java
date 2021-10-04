package Programmers.Level2;

// 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
// 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
// (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

class Square {
    public int solution(int [][]board) {
        int answer = 0;
        if (board.length == 1) {
            answer = board[0][0];
        } else {
            for (int row = 1; row < board.length; row++) {
                for (int col = 1; col < board[row].length; col++) {
                    if (board[row][col] == 1) {
                        board[row][col] = Math.min(Math.min(board[row - 1][col], board[row][col - 1]), board[row - 1][col - 1]) + 1;
                        answer = Math.max(answer, board[row][col]);
                    }
                }
            }
        }
        return answer * answer;
    }
}
