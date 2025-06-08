import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // 각 숫자의 등장 횟수 세기
        for (char ch : X.toCharArray()) {
            countX[ch - '0']++; // 아스키코드를 정수로 변환
        }
        for (char ch : Y.toCharArray()) {
            countY[ch - '0']++; // 아스키코드를 정수로 변환
        } 

        StringBuilder sb = new StringBuilder();
        
        // 9부터 0까지 공통 숫자(짝궁) 이어붙이기
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]);
            for (int j = 0; j < common; j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";  // "0000"처럼 0만 있을 경우
        
        return sb.toString();
    }
}
