class Solution {
    public int solution(String s) {
        int answer = 0;
        String S = s;
        String[] result = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < result.length; i++) {
            S = S.replace(result[i], i+"");
        }
        
        answer = Integer.parseInt(S);
        
        return answer;
    }
}