import java.util.HashMap;
class Solution {
    // 들어오는 간선 : in, 나가는 간선 : out
    // 루트 : in = 0 && out >= 2 일때
    // 도넛 : in = 1 && out = 1 일때
    // 막대 : 시작과 끝은 in 또는 out이 1개이며 나머지는 in과 out이 1일때
    // 8자 : 중앙은 in, out = 2이며, 나머지는 1일때
    public int[] solution(int[][] edges) {
        
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        
        int[] answer = new int[4];
        
        for(int[] e : edges) {
            // getOrDefault(key, value)는 key값이 없으면 value를 반환하고 있으면 그대로 key값을 반환한다.
            out.put(e[0], out.getOrDefault(e[0], 0) + 1);
            in.put(e[1], in.getOrDefault(e[1], 0) + 1);
        }
        
        // keySet()은 Map에 들어있는 키만 모아놓은 Set뷰를 돌려주는 메서드
        for(int node : out.keySet()) {
            if(out.get(node) >= 2) {
                if(!in.containsKey(node)) { // out이 2이상이면서 in이 없는 node : 루트
                    answer[0] = node;
                } else {
                answer[3] += 1; // out이 2이상이면서 in이 있으면 : 8자
            }
            } 
        }
        
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) { // in이 있는 node가 out이 없으면 막대
                answer[2] += 1;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}