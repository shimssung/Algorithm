class Solution {
    int answer = 0; // 누적 결과를 저장할 멤버 변수

    public int solution(int a, int b, int n) {
        exchange(n, a, b); // 재귀 시작
        return answer;
    }

    // x: 현재 병 수, a: 교환에 필요한 병 수, b: 교환으로 얻는 새 병 수
    public void exchange(int x, int a, int b) {
        if (x < a) return; // 더 이상 교환 불가하면 종료

        int newCoke = (x / a) * b;
        answer += newCoke;

        int remain = (x % a) + newCoke; // 다음 재귀에 넘길 병 수
        exchange(remain, a, b); // 재귀 호출
    }
}