import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int result = nums.length/2;
        // HashMap에 넣기
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int l = map.size();
        answer = l <= result ? l : result;
        
        return answer;
    }
}