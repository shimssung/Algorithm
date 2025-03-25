import java.util.*;
class Solution {
    // players: 등수가 담긴 배열
    // callings: 해설진이 부른 이름을 담은 문자열 배열
    public String[] solution(String[] players, String[] callings) {
        // 해당 인덱스를 값으로 인덱스의 이름을 키로 설정
        // 해설진이 부름사람의 이름으로 현재 등수를 해쉬맵으로 가져온다.
        // HashMap에서 현재 등수를 -1
        // 해당 등수와 (해당 등수-1)과 players 배열 교체, 다음등수이름을 저장 -> 등수 변경
        // 저장한 다음등수의 이름으로 HashMap에서 찾아서 값을 +1 해주기
        HashMap<String, Integer> player = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            player.put(players[i], i+1);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int rank = 0; // 등수
            rank = player.get(callings[i]); //"kai 가 현재 4등 - rank:4"
            player.put(callings[i], rank-1); // 해설진이 부른 이름 등수 -1    - kai의 랭크 -1
            String temp = "";
            temp = players[rank-2]; // 해설진이 부름 이름 등수 배열순서니까 -1해줘야함. / 지금 4등이고 추월당한 사람의 배열은 3등 즉 배열에서는 2임
            player.put(temp, rank); // 추월 당한 사람의 등수 +1    / rank:4
            players[rank-2] = players[rank-1]; // 내 앞 사람을 현재 등수로
            players[rank-1] = temp;
        }
        
        return players;
    }
}