class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        String[] result = (x + "").split("");
        int num = 0;
        for(int i = 0; i < result.length; i++) {
            num += Integer.parseInt(result[i]);
        }
        
        if(x%num == 0) answer = true;
        
        return answer;
    }
}