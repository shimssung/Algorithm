import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clotheslist = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            clotheslist.put(clothes[i][1], clotheslist.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        if(clotheslist.size() > 1) {
            for(int n : clotheslist.values()) {
                answer *= (n + 1); // 각 종류마다 (n + 1) 안입는것도 생각
            }
        } else {
            for(int n : clotheslist.values()) {
                answer += n;
            }
        }
        
        
        return answer-1;
    }
}