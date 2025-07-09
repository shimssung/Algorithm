class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 이차배열 만들기
        int h = n % w > 0 ? n / w + 1 : n / w;
        int[][] map = new int[h][w];
        
        int[] position = new int[2];
        
        
        int number = 1;
        for(int i = 0; i < h && number <= n; i++) {
            if(i % 2 == 1) {
                for(int j = 0; j < w && number <= n; j++) {
                    map[i][j] = number;

                    if(number == num) {
                        position[0] = i;
                        position[1] = j;
                    }
                    number++;
                }
            } else {
                for(int j = w-1; j >= 0 && number <= n; j--) {
                    map[i][j] = number;

                    if(number == num) {
                        position[0] = i;
                        position[1] = j;
                    }
                    number++;
                }
            }

        }
        
        
        for(int i = position[0]; i < h; i++) {
            
            if(map[i][position[1]] > 0) {
                answer++;
            }
        }
        
        
        return answer;
    }
}