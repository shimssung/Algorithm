class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int count = countDivisors(i);
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer;
    }

    // 약수의 개수를 세는 함수
    private int countDivisors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count += 1; // 제곱근이면 하나만 카운트
                } else {
                    count += 2; // 서로 다른 약수 두 개
                }
            }
        }
        return count;
    }
    
}