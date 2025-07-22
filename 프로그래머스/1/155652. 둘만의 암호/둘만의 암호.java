import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        // skip 문자열을 HashSet에 저장
        HashSet<Character> c = new HashSet<>();
        for (char k : skip.toCharArray()) {
            c.add(k);
        }

        for (char ch : s.toCharArray()) {
            int count = 0;
            char nextChar = ch;

            // index만큼 건너뛰며 문자 변경
            while (count < index) {
                nextChar++;

                if (nextChar > 'z') {
                    nextChar = 'a';  // z를 넘어가면 a로
                }

                if (!c.contains(nextChar)) {
                    count++;
                }
            }

            answer += nextChar;
        }

        return answer;
    }
}
