import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 한사람이 여러번 신고해도 1회로 인정.
        // k번 이상 신고 당한 사람은 정지
        // 정지된 사람을 신고했을경우 +1 씩 리턴.
        
        HashMap<String, Integer> list = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            list.put(id_list[i], i);
        }
        
        // 신고당한 사람을 key로 신고한 사람을 value로 HashMap생성
        HashMap<String, HashSet<String>> reported = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String[] report_result = report[i].split(" ");
            String reporter = report_result[0];
            String target = report_result[1];
            if (!reported.containsKey(target)) {
                reported.put(target, new HashSet<>());
            }
            reported.get(target).add(reporter);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            if(reported.containsKey(id_list[i]) && reported.get(id_list[i]).size() >= k) {
                for (String reporter : reported.get(id_list[i])) {
                    int index = list.get(reporter);
                    answer[index]++;
                }
            }
        }
        
        
        
        
        
        
        
        return answer;
    }
}