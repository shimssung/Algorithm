class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        String[] result = phone_number.split("");
        for(int i = result.length-5; i >= 0; i--) {
            result[i] = "*";
        }
        
        for(String s : result) answer += s;
        
        return answer;
    }
}