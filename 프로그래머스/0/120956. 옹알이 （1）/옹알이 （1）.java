import java.util.*;

class Solution {
    
    // aya, ye, woo, ma를 String 배열에 넣는다.
    // babbling에서 단어들을 없앤다.
    // 후 공백이면 count++
    
    public int solution(String[] babbling) {
        int count = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String babble : babbling) {
            int idx = 0;              // 현재 문자열 위치 인덱스
            boolean isValid = true;   // 발음 가능한지 여부

            while (idx < babble.length()) {
                boolean matched = false;

                for (String word : words) {
                    if (babble.startsWith(word, idx)) {

                        idx += word.length();    // 인덱스를 발음 길이만큼 전진
                        matched = true;
                        break;
                    }
                }

                if (!matched) {   // 네 개의 발음 중 하나도 매치 안 되면 실패
                    isValid = false;
                    break;
                }
            }

            if (isValid) count++;
        }

        return count;

    }
}

// comment
// 이전 방식은 replace 방식을 사용함 -> 문제발생 -> wyeoo 일때 ye가 먼저 삭제되고 남은 woo가 삭제되며 발음 가능한걸로 인식
// startsWirth()를 사용해 문자열을 하나씩 쪼개서 처음시작하는 문자하나먼저 인식하도록 수정 w로 시작하면서 woo와 맞는지 확인