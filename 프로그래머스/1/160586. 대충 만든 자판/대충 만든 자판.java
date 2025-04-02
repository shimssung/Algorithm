
// 이상한 휴대폰 자판을 이용해 특정 문자열을 작성하는 최소 클릭 횟수.
// 할당된 문자들이 담긴 문자열 : keymap
// 입력하려는 문자열들이 담긴 배열 : targets
// 문자열을 작성할 수 없을 때는 -1 return
import java.util.*;
class Solution {
    
    // 풀이: for문과 HashMap을 이용해 해당 (인덱스 + 1)을 값, 문자를 Key로 저장
    // targets에서 해당 문자가있는지 HashMap에서 containsKey() 메소드를 이용해 있으면 해당 값을 answer에 더하고, 없으면 -1
    // 추가로 최소 값을 구해야 하기 때문에 HashMap에 저장할 때 key값이 이미 있다면 패스
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> key = new HashMap<>();
        
        // 각 문자의 최소 클릭횟수를 HashMap에 저장
        for(int i = 0; i < keymap.length; i++) {
            
            char[] keys = keymap[i].toCharArray();
            
            for(int j = 0; j < keys.length; j++) {
                
                // key라는 HashMap 안에 해당 문자가 있는지 확인
                if(!key.containsKey(keys[j]) || key.get(keys[j]) > j+1) {
                    key.put(keys[j], j+1);
                }
            }
        }
        
        
        
        
            // target이 HashMap에있으면 해당 값(횟수)을 answer에 더하고 없으면 -1으로 대체하고 다음 문장 최소횟수 구하기.
        for(int i = 0; i < targets.length; i++) {
            
            char[] target = targets[i].toCharArray();
            boolean go = true;
            
            for(int j = 0; j < target.length; j++) {

                if(key.containsKey(target[j])) {

                    answer[i] += key.get(target[j]); 

                } else {  
                    answer[i] = -1;
                    break;
                }
            }
            
        }
        
        
        
        
        return answer;
    }
}