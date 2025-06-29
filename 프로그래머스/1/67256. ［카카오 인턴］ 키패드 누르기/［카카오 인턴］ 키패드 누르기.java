import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        String answer = "";
        
        // 왼손은 *에서 시작, 오른손은 #에서 시작
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
        };
        
        Map<Integer, int[]> numberMap = new HashMap<>();
        Map<String, int[]> handMap = new HashMap<>();
        
        handMap.put("left", new int[] {3, 0});
        handMap.put("right", new int[] {3, 2});
        
        for(int i = 0; i < keypad.length; i++) {
            for(int j = 0; j < keypad[0].length; j++) {
                if(keypad[i][j] != -1) {
                    numberMap.put(keypad[i][j], new int[]{i, j});
                }
            }
        }
        
        for(int i : numbers) {
            if(i == 1 || i == 4 || i == 7) {
                answer += "L";
                int[] location = numberMap.get(i);
                handMap.put("left", new int[] {location[0], location[1]});
            } else if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                int[] location = numberMap.get(i);
                handMap.put("right", new int[] {location[0], location[1]});
            } else if(i == 2 || i == 5 || i == 8 || i == 0){
                int[] location = numberMap.get(i);
                int[] left = handMap.get("left");
                int leftdiffX = Math.abs(left[0] - location[0]);
                int leftdiffY = Math.abs(left[1] - location[1]);
                int leftdiff = leftdiffX + leftdiffY;
                
                int[] right = handMap.get("right");
                int rightdiffX = Math.abs(right[0] - location[0]);
                int rightdiffY = Math.abs(right[1] - location[1]);
                int rightdiff = rightdiffX + rightdiffY;
                
                if(leftdiff > rightdiff) {
                    answer += "R";
                    handMap.put("right", new int[] {location[0], location[1]});
                } else if(leftdiff < rightdiff){
                    answer += "L";
                    handMap.put("left", new int[] {location[0], location[1]});
                } else if (leftdiff == rightdiff){
                    if(hand.equals("left")) {
                        answer += "L";
                        handMap.put("left", new int[] {location[0], location[1]});
                    } else {
                        answer += "R";
                        handMap.put("right", new int[] {location[0], location[1]});
                    }
                }
            }
        }
        
        
        return answer;
    }
}