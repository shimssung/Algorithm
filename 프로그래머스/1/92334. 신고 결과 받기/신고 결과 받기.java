import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>();
        
        // 중복제거
        for(int i = 0; i < report.length; i++) {
            reportSet.add(report[i]);
        }
        
        // 신고 기록 ( 신고당한 사람, 신고한 사람들)
        Map<String, Set<String>> reportedBy = new HashMap<>();
        for(String r : reportSet) {
            String[] m = r.split(" ");
            String reporter = m[0];
            String reported = m[1];
            
            // reported라는 이름이 맵에 없으면, 새로 만들어 집어넣는다.
            reportedBy.putIfAbsent(reported, new HashSet<>());
            reportedBy.get(reported).add(reporter);
        }
        
        // 정지된 유저 확인
        Map<String, Integer> mailCount = new HashMap<>();
        for (String reported : reportedBy.keySet()) {
            Set<String> reporters = reportedBy.get(reported); // 신고자 목록
            if (reporters.size() >= k) { // 정지 조건 만족
                for (String reporter : reporters) {
                    // reporter가 메일 한 통 받음
                    mailCount.put(reporter, mailCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        // id_list 순서대로 결과 배열 채우기
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }
        
        
        return answer;
    }
}