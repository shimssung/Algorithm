import java.util.HashMap;

class Solution {
    public String solution(String X, String Y) {
            
        // 각 해쉬맵을 만들자. 공통이있으면 해당 해쉬맵중 작은값을 가져온 후 정렬
        HashMap<String, Integer> Xmap = new HashMap<>();
        HashMap<String, Integer> Ymap = new HashMap<>();
        
        char[] Xchar = X.toCharArray();
        char[] Ychar = Y.toCharArray();
        
        for (char ch : X.toCharArray()) {
            String s = String.valueOf(ch);
            Xmap.put(s, Xmap.getOrDefault(s, 0) + 1);
        }
        for (char ch : Y.toCharArray()) {
            String s = String.valueOf(ch);
            Ymap.put(s, Ymap.getOrDefault(s, 0) + 1);
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            String digit = String.valueOf(i);
            if(Xmap.containsKey(digit) && Ymap.containsKey(digit)) {
                int Xnumb = Xmap.get(digit);
                int Ynumb = Ymap.get(digit);
                int Znumb = Math.min(Xnumb, Ynumb);
                for(int j = 0; j < Znumb; j++) {
                    answer.append(digit);
                }
                
            }
        }
        
        if (answer.length() == 0) return "-1";       // 공통 숫자 없음
        if (answer.charAt(0) == '0') return "0"; // 0000 처럼 0만 있는 경우
        
        
        return answer.toString();
    }
}