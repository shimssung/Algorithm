import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] m1 = {1,2,3,4,5};
        int[] m2 = {2,1,2,3,2,4,2,5};
        int[] m3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == m1[i%m1.length]) { score[0]++; }
            if(answers[i] == m2[i%m2.length]) { score[1]++; }
            if(answers[i] == m3[i%m3.length]) { score[2]++; }
        }
        
        int top = score[0] > score[1] ? score[0] : score[1];
        top = top > score[2] ? top : score[2];
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            if(score[i] == top) {
                ans.add(i+1);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
