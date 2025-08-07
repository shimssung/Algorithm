import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 0은 빈칸
        // 터진 횟수 반환
        
        Stack<Integer> result = new Stack<>();
        
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i]-1] == 0) {
                    continue;
                } else {
                    result.push(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
            if(result.size() > 1) {
                if(result.get(result.size()-1) == result.get(result.size()-2)) {
                    answer += 2;
                    result.pop();
                    result.pop();
                }
            }
        }
        
        return answer;
    }
}