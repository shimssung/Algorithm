class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String[] str = s.split("");
        
        int c1 = 0;
        int c2 = 0;
        
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("(")) c1++;
            if(str[i].equals(")")) {
                c2++;
                if(c1 < c2) answer = false;
            }
        }
        
        if(c1 != c2) answer = false;

        return answer;
    }
}