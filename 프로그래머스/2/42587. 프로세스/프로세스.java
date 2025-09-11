import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        
        List<Integer> list = new ArrayList<>();
        Deque<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            list.add(priorities[i]);
        }
        
        Collections.sort(list, (o1, o2) -> o2 - o1); // 내림차순
        
        for(int i : list) que.offer(i);
        int answer = 1;
        
        while(!que.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == que.peek()) {
                    if(i == location) {
                        return answer;
                    }
                    que.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }   
}