import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] answer = new int[N];
        int 도달 = stages.length;
        double[] 실패율 = new double[N];
        
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] != N+1) {
                answer[stages[i]-1] += 1; //해당 스테이지에 도달한 사람의 수
            }
        }
        
        for(int i = 0; i < N; i++) {
            실패율[i] = (double) answer[i]/도달;
            도달 -= answer[i];
            answer[i] = i+1; // 해당 스테이지 번호로 재사용
        }
        
        // 버블정렬
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < N-i; j++) {
                double tempD = 0;
                int tempI = 0;
                if(실패율[j-1] < 실패율[j]) {
                    tempD = 실패율[j];
                    실패율[j] = 실패율[j-1];
                    실패율[j-1] = tempD;
                    
                    tempI = answer[j];
                    answer[j] = answer[j-1];
                    answer[j-1] = tempI;
                }
            }
        }
        
        return answer;
    }
}