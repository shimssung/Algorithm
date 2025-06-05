class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        // a, b 숫자 붙이기
        String num1 = ""+a+b;
        // 붙인 문자열 숫자로 치환
        int num2 = Integer.parseInt(num1);
        
        // 2 * a * b
        int num3 = 2*a*b;
        
        answer = num2 > num3? num2 : num2 < num3 ? num3 : num2;
        
        return answer;
    }
}