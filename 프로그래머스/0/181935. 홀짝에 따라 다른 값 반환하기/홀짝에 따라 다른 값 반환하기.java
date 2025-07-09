class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 == 1) {
            for(int i = 1; i <= n; i++) {
                answer += i % 2 == 1 ? i : 0;
            }
        } else {
            for(int i = 2; i <=n; i++) {
                answer += i % 2 == 0 ? i*i : 0;
            }
        }
        
        return answer;
    }
}