import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 우선 문자를 하나씩으로 나눈다.
        // 점수가 4이하면 앞 문자를 4이상이면 뒷 문자를 4면 넘어간다.
        // 각 문자의 점수를 HashMap으로 저장한다.
        // (R, T), (C, F), (J, M), (A, N)으로 묶어서 점수를 계산하고 더 큰 값을 리턴
        // 둘다 없으면 넘어간다. 점수가 같을 경우 앞 유형을 선택
        String answer = "";

        // 각 유형별 점수 저장용 map
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);

        // 점수 대응표
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                map.put(first, map.get(first) + score[choice]);
            } else if (choice > 4) {
                map.put(second, map.get(second) + score[choice]);
            }
            // choice == 4는 점수 없음 (중립)
        }

        answer += map.get('R') < map.get('T') ? "T" : "R";
        answer += map.get('C') < map.get('F') ? "F" : "C";
        answer += map.get('J') < map.get('M') ? "M" : "J";
        answer += map.get('A') < map.get('N') ? "N" : "A";

        return answer;
    }
}