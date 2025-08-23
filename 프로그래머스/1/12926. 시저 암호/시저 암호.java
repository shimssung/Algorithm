class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {                 // 공백은 그대로
                sb.append(' ');
            } else if (c >= 'A' && c <= 'Z') { // 대문자
                int offset = c - 'A';
                char moved = (char)('A' + (offset + n) % 26);
                sb.append(moved);
            } else if (c >= 'a' && c <= 'z') { // 소문자
                int offset = c - 'a';
                char moved = (char)('a' + (offset + n) % 26);
                sb.append(moved);
            }
        }

        return sb.toString();
    }
}
