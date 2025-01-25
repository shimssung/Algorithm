class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] ch = my_string.toCharArray();
        char[] new_string = overwrite_string.toCharArray();
        for(int i = s; i < new_string.length+s; i++) {
            ch[i] = new_string[i-s];
        }
        
        String result = new String(ch);
        
        return result;
    }
}