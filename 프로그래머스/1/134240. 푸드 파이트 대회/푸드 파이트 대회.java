class Solution {
    public String solution(int[] food) {
        String answer = "0";
        
        // food[0] : 물 항상 1개임
        // food[i]는 해당 인덱스 음식의 개수 (짝수로만 사용가능)
        // 0을 시작으로 맨 뒤의 음식부터 앞뒤로 더하는 방식이 좋아보임.
        for(int i = food.length-1; i > 0; i--) {
            int n = food[i]/2;
            for(int j = 0; j < n; j++) {
                answer = i + answer + i;
            }
        }
        
        return answer;
    }
}