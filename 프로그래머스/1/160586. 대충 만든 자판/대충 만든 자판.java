import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // HashMap으로 해당 키의 최소값 넣고 targets꺼내면될듯
        HashMap<String, Integer> key = new HashMap<>();
        for(String k : keymap) {
            String[] s = k.split("");
            for(int i = 0; i < s.length; i++) {
                if(key.containsKey(s[i])) {
                    int n = key.get(s[i]);
                    if(n > i) {
                        key.put(s[i], i+1);
                    }
                } else {
                    key.put(s[i], i+1);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            String[] s = targets[i].split("");
            for(int j = 0; j < s.length; j++) {
                if(key.containsKey(s[j])) {
                    answer[i] += key.get(s[j]);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}