class Solution {
    
    // 로봇마다 정해진 운송 경로(routes)가 존재. n개의 포인트(points)를 순서대로 방문
    // 로봇은 x대, 0초에 동시에 출발.
    // 로봇은 1초마다 r(세로) 또는 c(가로) 중 하나가 +-1만큼의 자표로 이동 가능
    // 다음 포인트로 이동할때는 항상 최단 경로로 이동하며, 경로가 여러가지 일 경우 r이 우선순위
    // 같은 좌표에 로봇이 2대 이상 모이면 충돌이 발생
    // 충돌이 몇 번 일어나는지 알고싶다.
    
    public int solution(int[][] points, int[][] routes) {
        int[][] bot = new int[routes.length][2];
        int[] endbot = new int[routes.length];      // 목적지에 도착한 봇들
        int[] routeIndex = new int[routes.length];  // 현재 목적지의 인덱스를 추적
        int finish = 0;
        int botcount = 0;                           // 충돌 횟수

        // 초기 위치 설정
        for (int i = 0; i < routes.length; i++) {
            bot[i][0] = points[routes[i][0] - 1][0];
            bot[i][1] = points[routes[i][0] - 1][1];
            routeIndex[i] = 0;  // 첫 번째 목적지부터 시작
        }

        while (finish < routes.length) {
            int[][] map = new int[101][101];

            // 현재 위치 기록
            for (int i = 0; i < routes.length; i++) {
                if (endbot[i] != -1) {
                    map[bot[i][0]][bot[i][1]]++;
                }
            }

            // 충돌 계산
            for (int r = 0; r < 101; r++) {
                for (int c = 0; c < 101; c++) {
                    if (map[r][c] > 1) {
                        botcount++;
                    }
                }
            }

            // 로봇 이동
            for (int i = 0; i < routes.length; i++) {
                if (endbot[i] == -1) continue;

                // 현재 목적지의 좌표
                int targetR = points[routes[i][routeIndex[i] + 1] - 1][0];
                int targetC = points[routes[i][routeIndex[i] + 1] - 1][1];

                // 현재 목적지에 도착했는지 확인
                if (bot[i][0] == targetR && bot[i][1] == targetC) {
                    routeIndex[i]++;  // 다음 목적지로
                    // 모든 목적지를 방문했는지 확인
                    if (routeIndex[i] >= routes[i].length - 1) {
                        finish++;
                        endbot[i] = -1;
                        continue;
                    } else {
                        // 다음 목적지의 좌표로 갱신
                        targetR = points[routes[i][routeIndex[i] + 1] - 1][0];
                        targetC = points[routes[i][routeIndex[i] + 1] - 1][1];
                    }

                }

                // 이동 처리
                if (bot[i][0] != targetR) {
                    bot[i][0] += bot[i][0] < targetR ? 1 : -1;
                } else if (bot[i][1] != targetC) {
                    bot[i][1] += bot[i][1] < targetC ? 1 : -1;
                }
            }
        }
        return botcount;
    }
        
}