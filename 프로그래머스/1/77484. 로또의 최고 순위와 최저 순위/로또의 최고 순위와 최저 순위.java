import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // 알아볼수없는번호 : 0
        // 당첨 최고순위와 최저순위 리턴
        int zero = 0;
        int hit = 0;
        
        Set<Integer> nums = new HashSet<>();
        
        for(int n : win_nums) {
            nums.add(n);
        }
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zero++;
            if(nums.contains(lottos[i])) hit++;
        }
        
        int min = getRank(hit);
        int max = getRank(hit + zero);
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
    
    public int getRank(int count) {
        return count >= 2 ? 7 - count : 6;
    }
}