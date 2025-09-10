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
        
        
        // map.size()를 이용해 key개수 반환
        int l = map.size();
        answer = l <= result ? l : result;
        // key의 개수 <= result 일때 key의 개수 반환
        // key의 개수 > result 일때는 result 반환
        
        
        
        return answer;
    }
}