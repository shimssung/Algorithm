class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            for(int j = 0; j < 2; j++) {
                if(sizes[i][0] > sizes[i][1]) {
                    x = x < sizes[i][0] ? sizes[i][0] : x;
                    y = y < sizes[i][1] ? sizes[i][1] : y;
                } else {
                    x = x < sizes[i][1] ? sizes[i][1] : x;
                    y = y < sizes[i][0] ? sizes[i][0] : y;
                }
                
            }
        }
        
        return x * y;
    }
}