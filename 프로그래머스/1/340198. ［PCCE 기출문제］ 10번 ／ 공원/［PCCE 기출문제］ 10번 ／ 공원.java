import java.util.Arrays;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int x = park.length;
        int y = park[0].length;
        
        Arrays.sort(mats);
        
        // mats를 하나씩 꺼낸다.
        outer:
       for(int i = mats.length-1; i >= 0; i--) {
           // 공원의 크기와 돗자리의 크기를 뺏을때까지가 돗자리를 깔 수 있는자리.
           for(int j = 0; j <= x - mats[i]; j++) {
               for(int z = 0; z <= y - mats[i]; z++) {
                   boolean use = true;
                   for(int q = j; q < j + mats[i]; q++) {
                       for(int w = z; w < z + mats[i]; w++) {
                           if(!park[q][w].equals("-1")) {
                               use = false;
                               break;
                           }
                           
                       }
                       if(!use) {
                           break;
                       }
                   }
                   if(use) {
                       answer = mats[i];
                       break outer; // 즉시 모든 루프 탈출
                   }
               }
           }
       }
        
        return answer;
    }
}