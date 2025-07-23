import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        // 약관 종류별 유효기간 저장
        HashMap<String, Integer> tMap = new HashMap<>();
        for (String t : terms) {
            String[] s = t.split(" ");
            tMap.put(s[0], Integer.parseInt(s[1]));
        }

        // 오늘 날짜
        String[] todays = today.split("\\.");
        int todayY = Integer.parseInt(todays[0]);
        int todayM = Integer.parseInt(todays[1]);
        int todayD = Integer.parseInt(todays[2]);

        for (int i = 0; i < privacies.length; i++) {
            String[] result = privacies[i].split(" ");
            String[] s1 = result[0].split("\\.");

            int year = Integer.parseInt(s1[0]);
            int month = Integer.parseInt(s1[1]);
            int day = Integer.parseInt(s1[2]);

            // 약관 기간 더하기
            int plusMonth = tMap.get(result[1]);
            month += plusMonth;

            // 년/월 정리
            if (month > 12) {
                year += (month - 1) / 12;
                month = (month - 1) % 12 + 1;
            }

            // 오늘과 비교 (year, month, day 순)
            if (year < todayY || 
                (year == todayY && month < todayM) || 
                (year == todayY && month == todayM && day <= todayD)) {
                answer.add(i + 1); // 파기 대상
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
