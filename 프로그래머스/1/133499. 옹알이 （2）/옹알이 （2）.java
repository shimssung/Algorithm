class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            String temp = word;
            String prev = ""; // 이전 발음을 저장
            boolean isValid = true; // 현재 단어가 유효한지 여부

            while (!temp.isEmpty()) {
                boolean matched = false; // 현재 회차에서 발음 조각이 맞았는지 여부

                for (String sound : sounds) {
                    if (temp.startsWith(sound) && !sound.equals(prev)) {
                        // 앞에서부터 가능한 발음 + 이전 발음과 중복 아님
                        prev = sound; // 현재 발음을 이전 발음으로 저장
                        temp = temp.substring(sound.length()); // 발음한 부분 제거
                        matched = true; // 일치했음을 표시
                        break;
                    }
                }

                if (!matched) {
                    // 어떤 발음과도 일치하지 않으면 잘못된 단어
                    isValid = false;
                    break;
                }
            }

            if (isValid) answer++; // 모든 발음을 순차적으로 제거했고 조건을 만족하면 count 증가
        }

        return answer;
    }
}
