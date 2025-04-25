import java.util.*;

class Solution {
    
    // aya, ye, woo, ma를 String 배열에 넣는다.
    // babbling에서 단어들을 없앤다.
    // 후 공백이면 count++
    
    public int solution(String[] babbling) {
        int count = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String babble : babbling) {
            for(String word : words) {
                babble = babble.replace(word, "!");
            }
            babble = babble.replace("!", "");
            if(babble.isEmpty()) {
                count++;
            }
               
        }

        return count;

    }
}

// comment
// 이전 방식은 replace 방식을 사용함 -> 문제발생 -> wyeoo 일때 ye가 먼저 삭제되고 남은 woo가 삭제되며 발음 가능한걸로 인식
// startsWirth()를 사용해 문자열을 하나씩 쪼개서 처음시작하는 문자하나먼저 인식하도록 수정 w로 시작하면서 woo와 맞는지 확인
// 더 좋은 방식 -> 기존 replace방식을 살려서 원래는 ""이렇게 바로 없애버렸지만 1과 같은 숫자를  넣으면 w1oo 이되어서 인식을 못하게 만들수있음.