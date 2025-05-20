class Solution {
    
    // 기사는 자신의 기사 번호의 약수 개수에 해당하는 공력력을 가진 무기를  구매하려한다. 단, 제한수치가 있음
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] result = new int[number];
        
        for (int i = 1; i <= number; i++) {
            
            int count = 0;
            
            for(int j = 1; j * j<=i; j++) {
                if (i % j == 0) {
                    count++;
                    if (j != i / j) count++;  // 짝이 되는 약수도 카운트
                }
            }
            
            result[i-1] = count > limit ? power : count;
        }
        
        for(int num : result) {
            answer += num;
        }
        
        return answer;
    }
}