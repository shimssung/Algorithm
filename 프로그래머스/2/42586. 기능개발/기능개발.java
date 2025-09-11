import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            day = day * speeds[i] + progresses[i] < 100 ? day + 1 : day;
            que.offer(day);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!que.isEmpty()) {
            int first = que.poll();
            int count = 1;
            
            while(!que.isEmpty() && first >= que.peek()) {
                count++;
                que.poll();
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}