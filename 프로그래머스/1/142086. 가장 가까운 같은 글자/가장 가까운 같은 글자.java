import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        
        
        HashMap<String, Integer> index = new HashMap<>();
        String[] S = s.split("");
        
        int[] answer = new int[S.length];
        
        for(int i = 0; i < S.length; i++) {
            if(index.containsKey(S[i])) {
                answer[i] = i - index.get(S[i]);
                index.put(S[i], i);
            } else {
                answer[i] = -1;
                index.put(S[i], i);
            }
        }
        
        return answer;
    }
}