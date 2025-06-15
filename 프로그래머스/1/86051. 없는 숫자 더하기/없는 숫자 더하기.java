class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        int numb = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            numb += numbers[i];
        }
        
        answer += 45 - numb;
        
        if(answer > -1) {
            answer += 1;
        }
        
        return answer;
    }
}