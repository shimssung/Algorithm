import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> map = new HashSet<>();
        
        for(String s : phone_book) map.add(s);
        
        for(String s : phone_book) {
            for(int i = 1; i < s.length(); i++) {
                if(map.contains(s.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}