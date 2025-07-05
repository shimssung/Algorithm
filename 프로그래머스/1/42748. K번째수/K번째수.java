import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int z = 0; z < commands.length; z++) {
            
            int i = commands[z][0];
            int j = commands[z][1];
            int k = commands[z][2];
        
            int[] result = new int[j-i + 1];

            // i부터 j까지 자르기
            int c = 0;
            for(int x = i - 1; x < j; x++) {
                result[c] = array[x];
                c++;
            }
            
            Arrays.sort(result);
            
            answer[z] = result[k-1];
        }
        
        
        return answer;
    }
}