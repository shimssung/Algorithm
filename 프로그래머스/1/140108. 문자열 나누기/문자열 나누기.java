class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        
        String[] S = s.split("");
        String first = S[0];
        for(int i = 0; i < S.length; i++) {
            if(S[i].equals(first)) {
                count++;
            } else if(!S[i].equals(first)) {
                count--;
            } 
            if(count == 0) {
                answer++;
                count = 0;
                if(i < S.length - 1) {
                    first = S[i+1];
                }
            } else if(i == S.length - 1) {
                answer++;
            }
        }
        
        
        return answer;
    }
}