class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        // 반복문을 통해 S와 E 지점을 찾아라
        // S는 x, y가 가장 작은 지점이 들어가야 하므로 최대값을 넣어놓는다.
        // E는 x, y가 가장 큰 지점을 찾아 넣어야 하므로 최소값을 넣어놓늗나.
        String[] l = wallpaper[0].split("");
        int[] S = {wallpaper.length, l.length};
        int[] E = {0,0};
        
        for(int x = 0; x < wallpaper.length; x++) {
            String[] Row = wallpaper[x].split("");
            for(int y = 0; y < Row.length; y++) {
               if(Row[y].equals("#")) {
                   S[0] = Math.min(S[0], x);
                   S[1] = Math.min(S[1], y);
                   E[0] = Math.max(E[0], x);
                   E[1] = Math.max(E[1], y);
               } 
            }
        }
        answer[0] = S[0];
        answer[1] = S[1];
        answer[2] = E[0]+1;
        answer[3] = E[1]+1;
        
        return answer;
    }
}