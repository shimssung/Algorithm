import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int answer = 0;
        
        // 점수 오름차순 정렬
        Arrays.sort(score);

        int length = score.length;

        for (int i = 0; i + m <= length; i += m) {
            int minInBox = score[length - i - m]; // 상자 내 최소 점수
            answer += minInBox * m;
        }
        
        return answer;
    }
}