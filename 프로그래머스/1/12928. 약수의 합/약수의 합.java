class Solution {
    public int solution(int n) {
        int answer = 1;
        
        if(n == 0) return 0;
        
        for(int i = 2; i <= n; i++) {
            if(n % i == 0) answer += i;
        }
        
        return answer;
    }
}