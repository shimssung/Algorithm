import java.util.HashMap;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxhealth = health;
        
        // t초 동안 붕대 감으면 1초마다 x만큼 회복
        // t초 연속 붕대 감기 성공하면 y만큼 추가 회복
        // 최대 체력 이상 회복 불가
        // 붕대 감기 도중 맞으면 취소, 해당 순간에는 체력 회복 x -> 공격 당하기 전까지만 회복 & 붕대 감는 시간 초기화
        // 맞으면 피해량 만큼 체력 감소. && 체력이 0이하면 죽음.
        // 남은 체력 return , 죽으면 -1리턴.
        // bandage[시전 시간, 초당 회복량, 추가 회복량]
        // attacks[[공격시간, 피해량], ...]
        
        
        
        // 맞을 라운드와 피해량 저장
        HashMap<Integer, Integer> attack = new HashMap<>();
        for(int i = 0; i < attacks.length; i++) {
            attack.put(attacks[i][0], attacks[i][1]);
        }
        
        int healcount = 0;
        
        int length = attacks[attacks.length-1][0];
        for(int i = 1; i <= length; i++) {
            if(attack.containsKey(i)) {
                healcount = 0;
                health -= attack.get(i);
                if(health <= 0) {
                    answer = -1;
                    break;
                }
            } else {
                healcount++;
                if(healcount == bandage[0]) {
                    health += bandage[1];
                    health += bandage[2];
                    healcount = 0;
                } else {
                    health += bandage[1];
                }
                if(health > maxhealth) {
                    health = maxhealth;
                }
            }
        }
        if(health > 0) {
            answer = health;
        }
        
        return answer;
    }
}