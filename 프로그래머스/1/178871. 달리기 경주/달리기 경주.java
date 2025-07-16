import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // HashMap으로 이름과 등수를 저장
        // callings에서 이름으로 해쉬값을 가져오고 해당 등수 - 1 위치와 교환.
        // 교환 후에는 해당 인덱스를 다시 값으로 각각 넣어준다.
        
        HashMap<String, Integer> player = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            player.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int index = player.get(callings[i]);
                String temp = players[index-1];
                players[index - 1] = players[index];
                players[index] = temp;
            
            player.put(players[index], player.get(players[index]) + 1);
            player.put(players[index-1], player.get(players[index - 1]) -1);
        }
        
        return players;
    }
}