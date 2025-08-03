class Solution {
    public long solution(int price, int money, int count) {
        long answer = -money;

        // 금액이 부족한값 return, 부족하지않으면 0 return
        for(int i = 1; i <= count; i++) {
            answer += i*price;
        }
        
        if(answer < 0)  {
            answer = 0;
        }
        
        return answer;
    }
}