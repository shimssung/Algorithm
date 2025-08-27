import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> result = new HashSet<>();
        
        for(int n : nums) result.add(n);
        
        int max = nums.length/2;
        
        return Math.min(result.size(), max);
    }
}