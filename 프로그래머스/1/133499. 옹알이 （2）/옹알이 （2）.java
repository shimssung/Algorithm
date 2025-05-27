class Solution {
    // 한번이라도 연속으로 같은 발음이 나오면 결국 발음을 할 수 없다는것.
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for (String babbleOrig : babbling) {
            String babble = babbleOrig;
            String prev = "";      // 직전에 사용된 발음
            boolean ok = true;     // 이 단어가 가능한지 여부
            
            // babble이 완전히 소진될 때까지 앞에서부터 매칭 시도
            while (!babble.isEmpty()) {
                boolean matched = false;
                
                for (String w : words) {
                    // 1) babble이 w로 시작해야 하고
                    // 2) 이전 발음(prev)과 같지 않아야 함
                    if (babble.startsWith(w) && !prev.equals(w)) {
                        matched = true;
                        prev = w;
                        // 매칭한 길이만큼 문자열을 잘라낸다
                        babble = babble.substring(w.length());
                        break;
                    }
                }
                
                // 어떤 단어도 매칭되지 않으면 불가능 처리
                if (!matched) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) answer++;
        }
        
        return answer;
    }
}
