import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // 이름별 점수 저장
        HashMap<String, Integer> point = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            point.put(name[i], yearning[i]);
        }
        
        // photo에 해당 이름이 언급된 횟수 저장
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if(point.containsKey(photo[i][j])) {
                    sum += point.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}