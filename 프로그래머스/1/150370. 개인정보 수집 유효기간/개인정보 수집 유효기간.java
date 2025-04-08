import java.util.*;

class Solution {
    // today : 오늘날짜
    // terms : [약관종류, 유효기간]
    // privacies : [날짜, 약관종류]
    
    // 오늘날짜를 년, 월, 일을 split을 이용해 나눠서 저장
    // 월에 약관에 해당하는 기간을 더해주고 12로 나눈 몫을 년에 더하고, 12로 나눈 나머지를 월에 넣어준다.
    // 일은 그대로 유지
    
    // 후 해당 날짜가 오늘날짜를 기준으로 유효기간이 지났는지 확인 후 지났으면 result에 index+1 로 넣기
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String[] toDay = today.split("\\.");

        int year = Integer.parseInt(toDay[0]);
        int month = Integer.parseInt(toDay[1]);
        int day = Integer.parseInt(toDay[2]);
        
        HashMap<String, Integer> termsMap = new HashMap<>();
        
        for(int i = 0; i < terms.length; i++) {
            String[] s_terms = terms[i].split(" ");
            termsMap.put(s_terms[0], Integer.parseInt(s_terms[1]));
        }
        
        List<Integer> expiredList = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            String[] s_privacies = privacies[i].split(" ");
            String[] p_today = s_privacies[0].split("\\.");
            
            int p_year = Integer.parseInt(p_today[0]);
            int p_month = Integer.parseInt(p_today[1]) + termsMap.get(s_privacies[1]);
            int p_day = Integer.parseInt(p_today[2]);

            // 이 부분 좀 더 이해 필요
            p_year += (p_month - 1) / 12;
            p_month = (p_month - 1) % 12 + 1;

            
            if (p_year < year ||
                (p_year == year && p_month < month) ||
                (p_year == year && p_month == month && p_day <= day)) {
            
                expiredList.add(i + 1);
            }
        }
        
        int[] answer = new int[expiredList.size()];
        for (int i = 0; i < expiredList.size(); i++) {
            answer[i] = expiredList.get(i);
        }
        
        
        
        return answer;
    }
}