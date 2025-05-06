import java.util.HashMap;
class Solution {
    
    // 문자열을 char[] 로 만든 후
    // 반복문을 통해 해당 글자를 key로 인덱스를 값으로 넣는다.
    // containskey를 통해 해당 글자가 처음이면 -1을 반환하고, 있으면 현재 인덱스 - containskey의 값을 반환
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        char[] text = s.toCharArray();
        HashMap<Character, Integer> key = new HashMap<>();
        
        for(int i = 0; i < text.length; i++) {
            if(!key.containsKey(text[i])) {
                key.put(text[i], i);
                answer[i] = -1;
            } else if(key.containsKey(text[i])) {
                answer[i] = i - key.get(text[i]);
                key.put(text[i], i);
            }
        }
        
        return answer;
    }
}