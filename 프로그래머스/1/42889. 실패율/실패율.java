import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 각 스테이지에 머물러 있는(도전 중인) 사람 수 카운트
        int[] 도전 = new int[N + 2]; // N+1(올클)까지 고려
        for (int s : stages) {
            if (s <= N + 1) 도전[s]++;
        }
        
        int 도달 = stages.length; // 해당 스테이지에 도달한 사람 수(분모)
        double[] 실패율 = new double[N + 1]; // 1..N 사용
        
        for (int i = 1; i <= N; i++) {
            if (도달 == 0) {
                실패율[i] = 0.0;
            } else {
                실패율[i] = (double) 도전[i] / 도달; // 실수 나눗셈
                도달 -= 도전[i]; // 다음 스테이지로 넘어간 사람 감소
            }
        }
        
        // 스테이지 번호 배열 만들고 실패율 기준 정렬 (내림차순), 동률이면 번호 오름차순
        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) order[i] = i + 1;

        Arrays.sort(order, (a, b) -> {
            if (실패율[b] == 실패율[a]) return Integer.compare(a, b);
            return Double.compare(실패율[b], 실패율[a]);
        });

        // int[]로 변환하여 반환
        int[] result = new int[N];
        for (int i = 0; i < N; i++) result[i] = order[i];
        return result;
    }
}