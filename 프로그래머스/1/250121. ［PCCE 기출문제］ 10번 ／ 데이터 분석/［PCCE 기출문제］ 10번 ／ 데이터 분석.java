import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    // data: 데이터 [code, date, maxumum, remain]
    // ext: 뽑아낼 데이터 기준
    // val_ext: 데이터 기준값
    // sort_by: 정렬 기준
    // data에서 ext값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순 정렬
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int index_ext = ext.equals("code") ? 0 : ext.equals("date") ? 1 : ext.equals("maximum") ?  2 : 3;
        int index_sort = sort_by.equals("code") ? 0 : sort_by.equals("date") ? 1 : sort_by.equals("maximum") ?  2 : 3;
        
        // 조건에 맞는 데이터를 필터링하여 리스트에 추가
        // List는 동적으로 크기가 변경되기때문에 편함
        List<int[]> filteredData = new ArrayList<>();
        for (int[] row : data) {
            if (row[index_ext] < val_ext) {
                filteredData.add(row);
            }
        }
        
        // 정렬
        filteredData.sort(Comparator.comparingInt(row -> row[index_sort]));

        // 리스트를 배열로 변환
        int[][] answer = new int[filteredData.size()][4];
        for (int i = 0; i < filteredData.size(); i++) {
            answer[i] = filteredData.get(i);
        }
        
        return answer;
    }
}