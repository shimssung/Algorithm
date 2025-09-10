import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        
        for(String k : map.keySet()) {
            answer *= map.get(k);
        }
        
        
        return answer - 1;
    }
}