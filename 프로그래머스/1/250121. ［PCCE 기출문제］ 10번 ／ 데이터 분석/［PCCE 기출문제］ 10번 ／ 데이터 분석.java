import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        
        // ext : 기준
        // val_ext : 기준값
        // sort_by : 오름차순 기준값
        
        // 기준값 인덱스 저장
        HashMap<String, Integer> sort = new HashMap<>();
        sort.put("code", 0);
        sort.put("date", 1);
        sort.put("maximum", 2);
        sort.put("remain", 3);
        
        List<int[]> result = new ArrayList<>();
        int index = sort.get(ext);
        for(int i = 0; i < data.length; i++) {
            if(data[i][index] < val_ext) {
                result.add(data[i]);
            }
            
        }
        
        Collections.sort(result, (a, b) -> Integer.compare(a[sort.get(sort_by)], b[sort.get(sort_by)]));
        int[][] answer = new int[result.size()][data[0].length];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        // int[][] answer = result.toArray(new int[result.size()][]); 로도 가능

        return answer;
    }
}