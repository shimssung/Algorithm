class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        // 둘 중 하나라도 #이면 전체 지도에서 #이다.
        // OR 연산
        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            int line = arr1[i] | arr2[i];
            String binary = String.format("%" + n + "s", Integer.toBinaryString(line));
            binary = binary.replace('1', '#').replace('0', ' ');
            result[i] = binary;
        }
        
        
        return result;
    }
}