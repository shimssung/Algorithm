import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<String> stack = new ArrayDeque<>();
        
        String[] str = s.split("");
        for(String s1 : str) {
            if(s1.equals("(")) {
                stack.push("(");
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}