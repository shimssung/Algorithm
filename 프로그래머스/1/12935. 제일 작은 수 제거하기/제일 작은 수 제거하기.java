import java.util.ArrayList;;

class Solution {
    public int[] solution(int[] arr) {
        // 가장 작은 수를 찾기
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        
        // List로 변환 후 최소값 제거
        ArrayList<Integer> result = new ArrayList<>();
        boolean removed = false;
        
        for (int num : arr) {
            if (num == min && !removed) {
                removed = true;  // 최소값을 한번만 제거하도록 처리
            } else {
                result.add(num);
            }
        }
        
        // 결과가 비어 있으면 [-1]을 리턴
        if (result.isEmpty()) {
            return new int[]{-1};
        }
        
        // int[]로 변환
        int[] arrResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrResult[i] = result.get(i);  // ArrayList의 각 값을 배열에 넣음
        }
        
        return arrResult;
    }
}
