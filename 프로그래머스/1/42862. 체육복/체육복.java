class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 앞이나 뒤로만 빌려줄수있음.
        // lost : 도난당한 번호
        // reserve : 여벌 번호
        
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            result[i] = 1;
        }
        
        for(int i = 0; i < lost.length; i++) {
            result[lost[i]-1] -= 1;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            result[reserve[i]-1] += 1;
        }
        
        for(int i = 0; i < n; i++) {
            if(result[i] == 0) {
                if(i != 0 && result[i-1] > 1) {
                    result[i-1]--;
                    result[i]++;
                } else if(i + 1 < n && result[i+1] > 1) {
                    result[i+1]--;
                    result[i]++;
                }
            }
        }
        
        for(int r : result) {
            if(r >= 1) answer++;
        }        
        return answer;
    }
}