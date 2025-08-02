class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x = 0;
        int y = 0;
        // 번호마다 큰건 왼쪽 작은건 오른쪽에 넣기
        // 가로길이와 세로길이의 값이 더 큰것만 넣기
        for(int i = 0; i < sizes.length; i++) {
            int min = Math.min(sizes[i][0], sizes[i][1]);
            int max = Math.max(sizes[i][0], sizes[i][1]);
            x = Math.max(x, min);
            y = Math.max(y, max);
        }
        answer = x * y;
        
        return answer;
    }
}