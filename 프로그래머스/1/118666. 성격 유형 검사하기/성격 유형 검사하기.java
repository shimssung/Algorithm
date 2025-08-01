import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[] point = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);
        
        // survey에서 0은 비동의쪽 1은 동의쪽
        // 4는 모르겠음.
        for (int i = 0; i < survey.length; i++) {
            char diagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                map.put(diagree, map.get(diagree) + point[choice]);
            } else if (choice > 4) {
                map.put(agree, map.get(agree) + point[choice]);
            }
        }
        
        answer += map.get('R') < map.get('T') ? "T" : "R";
        answer += map.get('C') < map.get('F') ? "F" : "C";
        answer += map.get('J') < map.get('M') ? "M" : "J";
        answer += map.get('A') < map.get('N') ? "N" : "A";
        
        return answer;
    }
}