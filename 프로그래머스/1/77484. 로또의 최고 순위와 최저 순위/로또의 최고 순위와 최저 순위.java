class Solution {
    // 처음 0을 제외한 나머지 숫자와 맞는 갯수 = 최저 순위
    // 최저 순위 + 0의 갯수 = 최고 순위
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int lowrank = 0;
        int count = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                    count++;
            }
        }
        
        for(int i = 0; i < win_nums.length; i++) {
            for(int j = 0; j < lottos.length; j++) {
                if(win_nums[i] == lottos[j]) {
                    lowrank++;
                }
            }
        }
        int[] score = {6, 6, 5, 4, 3, 2, 1};
        answer[0] = score[lowrank + count];
        answer[1] = score[lowrank]; 
        
        return answer;
    }
}