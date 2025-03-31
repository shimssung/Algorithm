class Solution {
    // n : 페인트가 칠해진 벽의 길이
    // 예산을 아끼기 위해 1미터 길이의 구역 n개로 나누고, 왼쪽부터 1~n까지 번호를 붙인다.
    // m : 벽에 페인트를 칠하는 롤러의 길이
    // 규칙: 1. 롤러가 벽에서 벗어나면 안된다.
    //       2. 구역의 일부분만 포함되도록 칠하면 안된다.
    // section: n, m, 구역의 번호가 담긴 정수 배열 ex) [2, 3, 6]
    // 롤러로 페인트칠해야하는 최소 횟수 return 
    
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        int next = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > next) {
                answer++;
                next = section[i] + m - 1;
            }
        }
        
        return answer;
    }
}