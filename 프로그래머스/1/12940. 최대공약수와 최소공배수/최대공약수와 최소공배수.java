class Solution {
    public int[] solution(int n, int m) {
        
       int gcd = 1; // 최대공약수 초기값

        // 1부터 작은 수까지 돌면서 공약수를 찾음
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i; // 나눠떨어지는 수 중 가장 큰 값 저장
            }
        }

        // 최소공배수 = 두 수의 곱 ÷ 최대공약수
        int lcm = (n * m) / gcd;

        return new int[] {gcd, lcm};
    }
}