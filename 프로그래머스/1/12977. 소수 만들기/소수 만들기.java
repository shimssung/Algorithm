class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int result = nums[i] + nums[j] + nums[k];
                    if (isPrime(result)) answer++;
                }
            }
        }
        
        

        return answer;
    }
    
    public boolean isPrime(int x) {
            if(x%2 == 0) return false;
            int r = (int) Math.sqrt(x);
            
            for(int i = 3; i <= r; i+=2) {
                if(x % i == 0) return false;
            }
            
            return true;
        }
}