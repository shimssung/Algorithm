import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] result = String.valueOf(n).split("");  // n을 문자열로 변환 후 split
        Arrays.sort(result, Collections.reverseOrder()); // 내림차순 정렬

        StringBuilder sb = new StringBuilder();
        for (String r : result) {
            sb.append(r);
        }

        return Long.parseLong(sb.toString()); // long으로 변환 후 반환
    
    }
}