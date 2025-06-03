class Solution {
    
    // 3명의 학생의 정수를 더했을때 0이되면 삼총사
    
    public int solution(int[] number) {
        int answer = 0;
        
        for(int x = 0; x < number.length; x++) {
            for(int y = x+1; y < number.length; y++) {
                for(int z = y+1; z < number.length; z++){
                    if(number[x] + number[y] + number[z] ==  0) {answer++;}
                }
            }
        }
        
        return answer;
    }
}