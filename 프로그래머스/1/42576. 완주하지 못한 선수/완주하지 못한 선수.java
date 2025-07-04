import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // partictpant : 참여자들
        // completion : 완주자들
        // 완주하지 못한 단 한명 리턴
        // 참가자중 동명이인이 있을 수 있다.
        
        HashMap<String, Integer> m = new HashMap<>();
        for(String p : participant) {
            m.put(p, m.getOrDefault(p,0)+1);
        }
        
        for(String c : completion) {
            if(m.get(c) == 1) {
                m.remove(c);
            } else if(m.get(c) > 1) {
                m.put(c, m.get(c) - 1);
            }
        }
        for (String key : m.keySet()) {
            if (m.get(key) == 1) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}