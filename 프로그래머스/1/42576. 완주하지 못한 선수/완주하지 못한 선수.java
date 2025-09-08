import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for(String s : completion) {
            map.put(s, map.get(s) - 1);
        }
        
        for(String k : map.keySet()) {
            if(map.get(k) == 1) {
                answer = k;
            }
        }
        
        return answer;
    }
}