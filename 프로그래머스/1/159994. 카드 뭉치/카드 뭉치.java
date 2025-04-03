class Solution {
    
    // 첫번째 카드뭉치: cards1
    // 두번째 카드뭉치: cards2
    // 원하는 단어 배열: goal
    
    // cards1의 index와 cards2의 index를 각각 만들어 놓고
    // cards1부터 시작해서(cards2부터해도 괜찮) 해당 index에 적혀있는 문자열이 필요한 문자열인지 판단
    // 필요한 문자열이면 가져다 쓰고 index++을 해준다. 
    // 필요한 문자열이 아니면 cards2에있는 index를 이용해 두번째 카드뭉치에서 필요한 문자열이 있는지 판단
    // 있으면 사용, 만약 둘다 없으며 NO를 반환.
    // 전부 사용하거나 문자열을 완성하면 YES를 반환.
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int card1 = 0;
        int card2 = 0;
        String answer = "";
        int count = 0;
        
        for(int i = 0; i < goal.length; i++) {
            if(card1 < cards1.length && goal[i].equals(cards1[card1])) {
                card1++;
                count++;
                continue;
            } else if(card2 < cards2.length && goal[i].equals(cards2[card2])) {
                card2++;
                count++;
                continue;
            } 
        }
        
        answer =  (cards1.length == card1 && cards2.length == card2 || count == goal.length) ? "Yes" : "No";
        
        return answer;
    }
}