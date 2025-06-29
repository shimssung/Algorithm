class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        
        // 1단계 소문자 치환
        answer = answer.toLowerCase();
        
        // 2단계 !, @, #, * 제거
        // 허용된 문자 외 모두 제거하는 방식으로 변경
        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        // 3단계 .하나 이상 .으로 치환
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계 아이디 처음 또는 끝에 .이있으면 제거
        // ^\\. : 시작 부분의 마침표
        // | : 또는 
        // \\.$ : 끝 부분의 마침표
        answer = answer.replaceAll("^\\.|\\.$", "");

        
        // 5단계 빈문자열이면 a로 반환
        if(answer.isEmpty()) {
            answer = "a";
        }
        
        // 6단계 16자 이상은 15자로 통일
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
        }
        
        // 6단계 자른 후, 끝에 . 이 있으면 제거
        answer = answer.replaceAll("\\.$", "");
        
        // 7단계 길이가 2자 이하면 맨 끝문자를 길이가 3이될때까지 반복
        if(answer.length() < 3) {
            int n = 3 - answer.length();
            for(int i = 0; i < n; i++) {
                answer += answer.substring(answer.length()-1);
            }
        }
        
            
            
        return answer;
    }
}