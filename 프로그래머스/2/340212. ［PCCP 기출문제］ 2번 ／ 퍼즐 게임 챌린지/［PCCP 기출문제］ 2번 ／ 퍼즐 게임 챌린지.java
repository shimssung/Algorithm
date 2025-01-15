class Solution {
    // diff: 현재 퍼즐의 난이도
    // time_cur: 현재 퍼즐의 소요 시간
    // time_prev: 이전 퍼즐의 소요 시간
    // level: 내 숙련도
    // diff <= level (난이도가 나랑 같거나 낮다면): 현재 퍼즐의 소요시간만큼 시간을 사용
    // diff > level: diff-level 번 틀린다. 1회마다 time_cur만큼 사용하고 + time_prev를 사용해 다시 풀어야함. 이걸 diff-level만큼 반복 후 time_cur 시간을 사용해야 끝남
    // diff > level: diff-level=n, ((time_cur + time_prev) * n) + time_cur
    // 퍼즐 게임의 제한 시간이 있음: limit
    // 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 정수로 return해야함.
    public int solution(int[] diffs, int[] times, long limit) {
        int Lowlevel = 1;
        int Maxlevel = 100000; // 문제의 제한에 따라 상한 값 설정
        int answer = 0; // 초기값 설정
        
        while (Lowlevel <= Maxlevel) {
            int mid = (Lowlevel + Maxlevel) / 2;
            long result = 0; // 소요 시간 초기화
            
            for (int i = 0; i < diffs.length; i++) {
                if (mid >= diffs[i]) {
                    result += times[i]; // 숙련도가 충분하면 소요 시간만 추가
                } else {
                    int diffGap = diffs[i] - mid; // 숙련도 차이 계산
                    result += (long) diffGap * (times[i] + (i > 0 ? times[i - 1] : 0)) + times[i];
                }
                
                if (result > limit) {
                    break; // 제한 시간을 초과하면 조기 종료
                }
            }
            
            if (result <= limit) {
                answer = mid; // 현재 숙련도로 가능하므로 정답 갱신
                Maxlevel = mid - 1; // 더 낮은 숙련도 탐색
            } else {
                Lowlevel = mid + 1; // 숙련도를 높여야 함
            }
        }
        
        return answer;
    }
}