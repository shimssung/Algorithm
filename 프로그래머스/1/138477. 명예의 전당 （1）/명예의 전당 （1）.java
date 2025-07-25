import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // 점수 넣어서 정렬하고 상위 3개만 꺼내기
        List<Integer> s = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            s.add(score[i]);
            Collections.sort(s);
            int n = s.size();
            if( n > k) {
                answer[i] = s.get(n-k);
            } else if( n <= k) {
                answer[i] = s.get(0);
            }
        }
        
        return answer;
    }
}