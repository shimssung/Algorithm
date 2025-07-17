class Solution {
    
    public int[] position(String r) {
        switch(r) {
            case "E":
                return new int[]{0, 1};
            case "W":
                return new int[]{0, -1};
            case "S":
                return new int[]{1, 0};
            case "N":
                return new int[]{-1, 0};
            default:
                return new int[]{0, 0}; // 혹은 예외 처리
        }
    }
    
    public int[] solution(String[] park, String[] routes) {
        
        int[] start = new int[2];
        
        int x = park.length;
        
        String[] parkRow = park[0].split("");
        int y= parkRow.length;
        
        String[][] map = new String[x][y];
        for(int i = 0; i < x; i++) {
            String[] Row = park[i].split("");
            for(int j = 0; j < y; j++) {
                map[i][j] = Row[j];
                if(Row[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            int[] go = position(route[0]);
            int count = Integer.parseInt(route[1]);
            
            int goX = start[0];
            int goY = start[1];
            boolean canMove = true;
            for(int j = 0; j < count; j++) {
                goX += go[0];
                goY += go[1];
                
                if(goX < 0 || goX >= x || goY < 0 || goY >= y || map[goX][goY].equals("X")) {
                    canMove = false;
                    break;
                }
                
            }
            
            if (canMove) {
                start[0] = goX;
                start[1] = goY;
            }
        }
        
        return start;
    }
}