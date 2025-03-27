class Solution {
    // wallpaper: 바탕화면의 상태 (문자열 배열, 빈칸: ".", 파일이 있는칸: "#")
    
    // 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고한다. 
    // 이중 반복문을 돌리고 #이 있는 위치의 X, Y의 최대와 최소를 알고있으면 될거같음.
    public int[] solution(String[] wallpaper) {
        
        int Xmin = 50;
        int Xmax = 0;
        int Ymin = 50;
        int Ymax = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            char[] paper = wallpaper[i].toCharArray();
            for(int j = 0; j < paper.length; j++) {
                if(paper[j] == '#') {
                    if(Xmin > j) {
                        Xmin = j; 
                    } 
                    if(Xmax < j){
                        Xmax = j; 
                    }
                    
                    if(Ymin > i) {
                        Ymin = i; 
                    } 
                    if(Ymax < i){
                        Ymax = i; 
                    }
                    
                }
            }
        }
        
        
        int[] answer = {Ymin, Xmin, Ymax+1, Xmax+1};
        return answer;
    }
}