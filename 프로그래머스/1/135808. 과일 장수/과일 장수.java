import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // m : 한 상자에 들어가는 사과의 수
        Arrays.sort(score);
        
        int index = score.length;
        // 뒤에서부터 k개수만큼 자르고 크기가 부족하면 인덱스 0반환.
        while(index - m >= 0) {
            index -= m;
            answer += score[index] * m;
        }
        
        return answer;
    }
}