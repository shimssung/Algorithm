import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) genre.add(key);
        
        Collections.sort(genre, (m1, m2) -> map.get(m2) - map.get(m1));
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(String s : genre) {
            int idx1 = -1;
            int first = 0;
            
            int idx2 = -1;
            int second = 0;
            
            for(int i = 0; i < genres.length; i++) {
                if(s.equals(genres[i])) {
                    if(first < plays[i]) {
                        idx2 = idx1;
                        second = first;
                        
                        idx1 = i;
                        first = plays[i];
                    } else if(second < plays[i]) {
                        idx2 = i;
                        second = plays[i];
                    }
                }
            }
            
            list.add(idx1);
            if(idx2 > -1) list.add(idx2);
            
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}