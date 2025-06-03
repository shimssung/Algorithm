class Solution {
    
    // 3명의 학생의 정수를 더했을때 0이되면 삼총사
    
    public int solution(int[] number) {
        int answer = 0;
        
        for(int x = 0; x < number.length; x++) {
            int num1 = number[x];
            for(int y = x+1; y < number.length; y++) {
                int num2 = number[y];
                for(int z = y+1; z < number.length; z++){
                    int num3 = number[z];
                    
                    if((num1 + num2 + num3) == 0) {answer++;}
                }
            }
        }
        
        return answer;
    }
}