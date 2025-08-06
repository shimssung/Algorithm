import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> result = new HashSet<>();
        
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                result.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            answer[idx++] = num;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}