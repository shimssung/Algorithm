class Solution {
    // 들어오는 간선 : in, 나가는 간선 : out
    // 루트 : in = 0 && out >= 2 일때
    // 도넛 : in = 1 && out = 1 일때
    // 막대 : 시작과 끝은 in 또는 out이 1개이며 나머지는 in과 out이 1일때
    // 8자 : 중앙은 in, out = 2이며, 나머지는 1일때
    public int[] solution(int[][] edges) {
        
        // 문제에서 정점 번호의 최댓값은 1_000_000
        int MAX = 1_000_000;
        
        /* 1) 정점별 in-degree / out-degree를 저장할 배열 준비
              - 인덱스: 정점 번호
              - 값   : 해당 정점의 차수(간선 수) */
        int[] indeg  = new int[MAX + 1];
        int[] outdeg = new int[MAX + 1];
        
        // 2) 모든 간선을 한 번 훑으며 차수를 계산 
        for (int[] e : edges) {
            outdeg[e[0]]++;   // 나가는 간선 +1
            indeg[e[1]]++;    // 들어오는 간선 +1
        }
        
        /* 3) ‘생성한 정점(루트)’ 찾기
              조건: indeg == 0 && outdeg ≥ 2
              문제 조건상 이런 정점은 정확히 1개 */
        int root = 0;
        for (int node = 1; node <= MAX; node++) {
            if (indeg[node] == 0 && outdeg[node] >= 2) {
                root = node;
                break;
            }
        }
        
        /* 4) 8자·막대 개수를 카운트
              - 8자 중앙: out >= 2 && indeg > 0
              - 막대 끝 : out == 0 && indeg > 0
              ※ 도넛은 이후에 총개수에서 빼서 계산     */
        int eight = 0;   // 8자 그래프 수
        int bar   = 0;   // 막대 그래프 수
        
        for (int node = 1; node <= MAX; node++) {
            if (outdeg[node] >= 2 && indeg[node] > 0) {
                eight++;          // 8자 중앙
            }
            if (outdeg[node] == 0 && indeg[node] > 0) {
                bar++;            // 막대 끝
            }
        }
        
        /* 5) 도넛 개수 = (루트에서 뻗은 전체 그래프 수) - 막대 - 8자
              └ 루트의 out-degree 가 바로 “총 그래프 개수” */
        int donut = outdeg[root] - bar - eight;
        
        /* 6) 결과 형식: [루트, 도넛 수, 막대 수, 8자 수] */
        return new int[] { root, donut, bar, eight };
    }
}