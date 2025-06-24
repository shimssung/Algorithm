class Solution {
    public int solution(String s) {
        
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < word.length; i++) {
            s = s.replace(word[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}