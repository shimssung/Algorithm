import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        System.out.println("Hello Java");
        Deque<Integer> que = new ArrayDeque<>();
        for(int a : arr) {
            if(!que.isEmpty() && a == que.peekLast()) {
                continue;
            } else {
                que.offer(a);
            }
        }
        int leng = que.size();
        int[] answer = new int[leng];
        for(int i = 0; i < leng; i++) {
            answer[i] = que.poll();
        }
        
        return answer;
    }
}