class Solution {
    
    // int는 최대 10자리까지 감당가능..
    public int solution(String t, String p)
    {
        int answer = 0;

        for(int i=0; i<=t.length()-p.length(); i++)
            if(Long.parseLong(t.substring(i, i+p.length())) <= Long.parseLong(p))
                answer++;

        return answer;
    }
}