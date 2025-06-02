class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
    
        int y = n;
        while(y>=a) {
            
            int x = y/a;
            answer += x*b;
            y = y - (x*a) + x*b;
            
        }
        
        return answer;
    }
}