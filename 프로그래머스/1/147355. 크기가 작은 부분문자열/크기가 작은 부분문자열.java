class Solution {
    
    public int solution(String t, String p) {
        
        int answer = 0;
        
        char[] t_char = t.toCharArray();
        char[] p_char = p.toCharArray();
        
        long p_long = Long.parseLong(p);
        
        for(int i = 0; i < t_char.length; i++) {
            String t_str = "";
            
            if(i+p_char.length-1 <= t_char.length-1) {
                long t_long = 0;
                for(int j = i;j < i+p_char.length; j++) {
                    t_str += t_char[j];
                    t_long = Long.parseLong(t_str);
                }
                answer += t_long <= p_long ? 1 : 0;
            }
        }
        
        
        return answer;
    }
}