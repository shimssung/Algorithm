class Solution {
    public int solution(String dartResult) {
        String[] s = dartResult.split("");
        int[] score = new int[3];
        int idx = 0;

        for (int i = 0; i < s.length; ) {
            // 1) 숫자 파싱 (10 처리)
            int now;
            if (s[i].equals("1") && i + 1 < s.length && s[i + 1].equals("0")) {
                now = 10;
                i += 2;
            } else {
                now = Integer.parseInt(s[i]);
                i++;
            }

            // 2) 보너스 S/D/T
            if (s[i].equals("S")) {
                // now 그대로
            } else if (s[i].equals("D")) {
                now = now * now;
            } else if (s[i].equals("T")) {
                now = now * now * now;
            }
            i++; // 보너스 문자 소비

            // 3) 옵션 (*, #) - 있을 수도 있음
            if (i < s.length) {
                if (s[i].equals("*")) {
                    now *= 2;
                    if (idx > 0) score[idx - 1] *= 2;
                    i++; // 옵션 소비
                } else if (s[i].equals("#")) {
                    now *= -1;
                    i++; // 옵션 소비
                }
            }

            score[idx++] = now;
        }

        return score[0] + score[1] + score[2];
    }
}
