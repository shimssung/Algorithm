import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();
        
        for(int a : arr) {
            if(stack.isEmpty() || a != stack.peek()) {
                stack.push(a);
            }
        }
        
        int leng = stack.size();
        int[] answer = new int[leng];
        
        for(int i = 1; i <= leng; i++) {
            answer[leng-i] = stack.pop();
        }
        
        return answer;
    }
}