import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i : ingredient) {
            list.add(i);
            int n = list.size();
            if(n >= 4) {
                if(list.get(n-1) == 1 && list.get(n-2) == 3 && list.get(n-3) == 2 && list.get(n-4) == 1) {
                    answer += 1;
                    list.remove(n-1);
                    list.remove(n-2);
                    list.remove(n-3);
                    list.remove(n-4);
                }
            }
        }
        
        
        return answer;
    }
}