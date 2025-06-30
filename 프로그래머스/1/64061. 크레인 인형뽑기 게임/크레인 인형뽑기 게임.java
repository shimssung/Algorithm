import java.util.List;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 숫자는 각기 다른 인형
        // 같은 숫자가 연속으로 바구니에 들어가면 사라진다 answer++
        
        int answer = 0;
        
        // 바구니
        List<Integer> b = new LinkedList<>();
        
        // moves만큼 반복
        for(int m : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][m-1] > 0) {
                    b.add(board[i][m-1]);
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        
        boolean boom = true;
        while(boom) {
            boom = false;
            for(int i = b.size()-1; i > 0; i--) {
                if(b.get(i).equals(b.get(i - 1))) {
                    b.remove(i);
                    b.remove(i-1);
                    boom = true;
                    answer += 2;
                }
            }
        }
        
        return answer;
    }
}