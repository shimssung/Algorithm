class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dh = {0, 0, 1, -1};
        int[] dw = {1, -1, 0, 0};
                    
        for(int i = 0; i < 4; i++) {
            int checkH = h + dh[i];
            int checkW = w + dw[i];
            if(checkH > -1 && checkW > -1 && checkH < board.length && checkW < board.length && board[h][w].equals(board[checkH][checkW])) {
                answer++;
            }
        }
        
        return answer;
    }
}