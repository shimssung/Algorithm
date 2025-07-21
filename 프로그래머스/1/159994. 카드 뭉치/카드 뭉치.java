class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        // 각가 인덱스를 만들고 가져올수있는지 확인
        int c1 = 0;
        int c2 = 0;
        int count = 0;
        for(int i = 0; i < goal.length; i++) {
            if(c1 < cards1.length && cards1[c1].equals(goal[i])) {
                c1++;
                count++;
            } else if(c2 < cards2.length && cards2[c2].equals(goal[i])  ) {
                c2++;
                count++;
            } else {
                answer = "No";
                break;
            }
            
        }
        
        if(count == goal.length) {
            answer = "Yes";
        }
        
        return answer;
    }
}