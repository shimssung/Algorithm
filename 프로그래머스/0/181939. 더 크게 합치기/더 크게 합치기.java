class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String Num1 = "" + a + b;
        String Num2 = "" + b + a;

        int A = Integer.parseInt(Num1);
        int B = Integer.parseInt(Num2);
        
        
        int c = A < B ? B : A;

        return c;
    }
}