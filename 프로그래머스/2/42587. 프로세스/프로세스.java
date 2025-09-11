import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Deque<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            list.add(priorities[i]);
            que.offer(i);
        }
        
        Collections.sort(list, (o1, o2) -> o2 - o1); // 내림차순
        
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()) {
            int idx = que.poll();
            if(map.get(idx) == list.get(0)) {
                result.add(idx);
                list.remove(0);
            } else {
                que.offer(idx);
            }
        }
        
        return result.indexOf(location)+1;
    }
}