class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;  // 단어 내에서의 인덱스

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                idx = 0; // 공백 만나면 단어 인덱스 초기화
            } else {
                if (idx % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                idx++;
            }
        }
        
        
        
        return answer.toString();
    }
}