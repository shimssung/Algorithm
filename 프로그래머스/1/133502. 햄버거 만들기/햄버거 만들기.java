import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> s = new Stack<>();
        for(int i : ingredient) {
            s.push(i);
            int n = s.size();
            if(n >= 4) {
                if(s.get(n-1) == 1 && s.get(n-2) == 3 && s.get(n-3) == 2 && s.get(n-4) == 1) {
                    answer += 1;
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();
                }
            }
        }
        
        
        return answer;
    }
}