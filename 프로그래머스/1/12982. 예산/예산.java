import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int count = 0;
        for(int i : d) {
            count += i;
            if(budget >= count) answer++;
        }
        
        return answer;
    }
}