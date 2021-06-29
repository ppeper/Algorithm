import java.util.EmptyStackException;
import java.util.Stack;

//카카오 겨울 인턴십 문제
class CranePuppet {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i]-1] != 0){
                    try{
                        if(board[j][moves[i]-1] == stack.peek()){
                            answer += 2;
                            stack.pop();
                        }else{
                            stack.push(board[j][moves[i]-1]);
                        }
                    }catch(EmptyStackException e){
                        stack.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}