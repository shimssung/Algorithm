class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        int next = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > next) {
                answer++;
                next = section[i] + m - 1;
            }
        }
        
        return answer;
    }
}