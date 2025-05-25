import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // 1 : 빵, 2: 야채, 3: 고기
    
    public int solution(int[] ingredient) {
        
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            int size = list.size();
            
            if(size >= 4 
               && list.get(size-4) == 1 
               && list.get(size-3) == 2 
               && list.get(size-2) == 3 
               && list.get(size-1) == 1 ){
                answer++;
                   
                   for(int j = 0; j < 4; j++) {
                       list.remove(list.size() - 1);
                   }
            }
        }
        
        
        return answer;
    }
}