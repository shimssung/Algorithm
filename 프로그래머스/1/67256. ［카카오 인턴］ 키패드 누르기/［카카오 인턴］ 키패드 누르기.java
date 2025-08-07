import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 왼손 : * 시작
        // 오른손 : # 시작
        // 1, 4, 7 왼손
        // 3, 6, 9 오른손
        
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
        };
        
        HashMap<Integer, int[]> number = new HashMap<>();
        for(int i = 0; i < keypad.length; i++) {
            for(int j = 0; j < keypad[0].length; j++) {
                if(keypad[i][j] != -1) {
                    number.put(keypad[i][j], new int[]{i, j});
                }
            }
        }
        
        HashMap<String, int[]> handMap = new HashMap<>();
        handMap.put("L", new int[]{3, 0});
        handMap.put("R", new int[]{3, 2});
        
        for(int i : numbers) {
            if(i == 1 || i == 4 || i == 7) {
                answer += "L";
                handMap.put("L", number.get(i));
            } else if(i == 3 || i == 6 || i == 9) {
                answer += "R";
                handMap.put("R", number.get(i));
            } else {
                int Lcount = 0;
                int Rcount = 0;
                int x = number.get(i)[0];
                int y = number.get(i)[1];
                Lcount = Math.abs(handMap.get("L")[0] - x) + Math.abs(handMap.get("L")[1] - y);
                Rcount = Math.abs(handMap.get("R")[0] - x) + Math.abs(handMap.get("R")[1] - y);
                
                if(Lcount < Rcount) {
                    answer += "L";
                    handMap.put("L", number.get(i));
                } else if(Lcount > Rcount) {
                    answer += "R";
                    handMap.put("R", number.get(i));
                } else if(Lcount == Rcount) {
                    if(hand.equals("right")) {
                        answer += "R";
                        handMap.put("R", number.get(i));
                    } else {
                        answer += "L";
                        handMap.put("L", number.get(i));
                    }
                }
            }
        }
        
        
        return answer;
    }
}