class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        String[] x = t.split("");
        String[] y = p.split("");
        int count = 0;
        String result = "";
        
        Long n1 = Long.parseLong(p);
        
        for(int i = 0; i <= x.length - y.length; i++) {
            for(int j = 0; j < y.length; j++) {
                result += x[i+j];
            }
            Long n2 = Long.parseLong(result);
            answer += n2 <= n1 ? 1 : 0;
            result = "";
            
        }
        
        return answer;
    }
}