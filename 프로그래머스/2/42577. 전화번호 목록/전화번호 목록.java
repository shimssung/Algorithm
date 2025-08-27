import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> key = new HashSet<>();
        
        for(String s : phone_book) key.add(s);
        
        for(String s : phone_book) {
            for(int i = 1; i < s.length(); i++) {
                if(key.contains(s.substring(0, i))) return false;
            }
        }
        
        return true;
    }
}