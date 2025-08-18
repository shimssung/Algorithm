class Solution {
    public long solution(long n) {
        
        long num = (long) Math.sqrt(n); 
        if (num * num == n) {        // 제곱수 판정
            return (num + 1) * (num + 1);  // (x+1)^2 반환
        }
        
        return -1;
    }
}