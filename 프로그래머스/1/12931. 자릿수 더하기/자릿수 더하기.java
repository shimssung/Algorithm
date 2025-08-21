import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String[] s = String.valueOf(n).split("");
        
        for(String i : s) {
            answer += Integer.parseInt(i);
        }

        return answer;
    }
}