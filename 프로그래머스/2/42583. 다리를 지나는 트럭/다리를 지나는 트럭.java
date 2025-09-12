import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int cur = 0;
        int idx = 0;
        
        Deque<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) que.offer(0);
        
        
        while(!que.isEmpty()) {
            time++;
            cur -= que.poll();
            if(idx < truck_weights.length) {
                int next = truck_weights[idx];
                
                if(cur + next > weight) {
                    que.offer(0);
                } else {
                    que.offer(next);
                    cur += next;
                    idx++;
                }
            }
        }
        
        
        return time;
    }
}