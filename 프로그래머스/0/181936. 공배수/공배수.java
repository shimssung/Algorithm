class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        
        if(number % n == 0) {
            answer = number % m == 0 ? 1 : 0;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}