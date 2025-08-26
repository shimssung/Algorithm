import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(long n, String[] bans) {
        
        long[] length = new long[12];
        length[0] = 1L;
        for(int i = 1; i < 12; i++) length[i] = length[i-1]*26L; // 1 ~ 11글자의 경우의 수를 미리 계산
        
        int[] banLenCount = new int[12]; // 길이별 금지어 개수
        for(String b : bans) banLenCount[b.length()]++;
        
        long k = n;
        int L = -1;
        for(int i = 1; i <= 11; i++) {
            long usable = length[i] - banLenCount[i]; // 해당 글자의 수에서 밴을 뺀 수
            if( k <= usable) {
                L = i;
                break;
            } else {
                k -= usable; // 앞 글자수만큼 제외(건너뜀)
            }
        }
        
        // 4) 길이 L 금지어들의 "접두사 → 개수" 맵 구성
        //    (길이 L에서 특정 접두사로 시작하는 금지어 개수)
        Map<String, Integer> prefixBanCount = new HashMap<>();
        for (String b : bans) {
            if (b.length() != L) continue;
            for (int i = 1; i <= L; i++) {
                String pref = b.substring(0, i);
                prefixBanCount.put(pref, prefixBanCount.getOrDefault(pref, 0) + 1);
            }
        }
        
        // 5) 길이 L 안에서 k번째 문자열 만들기 (접두사 단위로 덩어리 건너뛰기)
        StringBuilder ans = new StringBuilder();
        for (int pos = 0; pos < L; pos++) {
            for (char c = 'a'; c <= 'z'; c++) {
                long total = length[L - (pos + 1)]; // 이 자리 이후 남은 칸의 모든 조합
                int banned = prefixBanCount.getOrDefault(ans.toString() + c, 0);
                long usable = total - banned; // 금지어 시작 접두사만큼 제외

                if (k > usable) {
                    k -= usable; // 이 문자로 시작하는 덩어리 통째로 건너뜀
                } else {
                    ans.append(c); // 이 문자 확정
                    break;
                }
            }
        }

        return ans.toString();
    }
}