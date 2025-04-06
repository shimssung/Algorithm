
// 문자열 s를 바꿀건데 하나씩 index만큼 더한 문자로 바꿔주려한다.
// 단 index만큼 더해줄때 skip에 포함되어있으면 패스를 하고 넘어간다.
// z를 넘어갈 경우 다시 a로 돌아간다.
// a = 97, z = 122

// 우선 s를 char배열로 만들고, skip은 hashMap에 넣어놓는게 좋아보임.
// for each로 반복문을 만들어서 각 char에 들어있는 값을 +1하고 skip에 들어있는 값중 일치하는게 있다면 count를 ++하지 않는다.
// count의 값이 index와 일치한다면 break.

import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        // skip 문자열을 Set으로 저장 (빠른 lookup)
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int count = 0;
            char cur = ch;

            while (count < index) {
                cur++;

                // 'z' 넘어가면 'a'로 돌아가기
                if (cur > 'z') {
                    cur = 'a';
                }

                // skip에 포함되지 않으면 count++
                if (!skipSet.contains(cur)) {
                    count++;
                }
            }

            result.append(cur);
        }

        return result.toString();
    }
}