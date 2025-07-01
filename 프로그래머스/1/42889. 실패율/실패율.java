import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        
        // N : 전체 스테이지 수 ( 1 < N < 500 )
        // N + 1은 끝까지 클리어 한 사용자
        // stages : 멈춰있는 스테이지 번호 ( 1 < stages < 200,000 )
        
        // 실패율이 같다면 작은 번호의 스테이지가 먼저 오도록
        // 스테이지에 도달한 유저가 없을경우 실패율은 0
        
        // 실패율이 높은 순서대로 return
        int[] answer = new int[N];
        int[] stageCount = new int[N + 2]; // 각 스테이지에 멈춘 사람 수

        // 각 스테이지에 멈춘 사람 수 세기
        for (int stage : stages) {
            stageCount[stage]++;
        }

        int totalPlayers = stages.length;
        double[] failureRate = new double[N + 1]; // 스테이지별 실패율

        // 실패율 : 해당 스테이지 도달 유저 수 / 현재스테이지에 도달한 사람(전체 수 - 현재 스테이지까지 도달하지 못한 사람 수)
        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failureRate[i] = 0;
            } else {
                failureRate[i] = (double) stageCount[i] / totalPlayers;
                totalPlayers -= stageCount[i];
            }
        }

        // 스테이지 번호 리스트 생성
        List<Integer> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            stageList.add(i);
        }

        // 실패율 기준 정렬 (같으면 스테이지 번호 기준 오름차순)
        // 양수 리턴 : 자리 바꿈, 음수 리턴 또는 0 : 순서 유지
        Collections.sort(stageList, (a, b) -> {
            if (failureRate[b] > failureRate[a]) {
                return 1;
            } else if (failureRate[b] < failureRate[a]) {
                return -1;
            } else {
                return a - b; // 오름차순 (내램차순: b-a)
            }
        });

        // List → 배열로 변환
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i);
        }

        return answer;
    }
}