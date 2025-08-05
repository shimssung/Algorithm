class Solution {
    public int solution(int n) {
        // 1단계: 3진수로 변환
        String ternary = Integer.toString(n, 3);

        // 2단계: 문자열 뒤집기
        String reversed = new StringBuilder(ternary).reverse().toString();

        // 3단계: 다시 10진수로 변환
        int answer = Integer.parseInt(reversed, 3);
        
        
        
        return answer;
    }
}