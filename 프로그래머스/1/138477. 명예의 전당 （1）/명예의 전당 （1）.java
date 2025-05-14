import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> topScore = new ArrayList<>();
        
        for(int i = 0; i<score.length; i++) {
            topScore.add(score[i]); // 일단 추가
            // 정렬(오름차순)
            Collections.sort(topScore);
            
            if (topScore.size() > k) {
                topScore.remove(topScore.get(0)); // k개 초과면 가장 낮은 점수 제거
            }
            
            answer[i] = topScore.get(0); // 가장 낮은 점수 저장
        }
        
        
        return answer;
    }
}