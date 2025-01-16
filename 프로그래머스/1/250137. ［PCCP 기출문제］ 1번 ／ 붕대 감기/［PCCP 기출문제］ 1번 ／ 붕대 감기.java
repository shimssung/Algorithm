class Solution {
    // 붕대를 감으면 1초마다 x만큼의 체력을 회복
    // t초 연속으로 붕대를 감는데 성공하면 y만큼 체력을 추가로 회복
    // 현재 체력이 최대 체력보다 커지는것은 불가능
    // 공격을 당하면 기술이 취소
    // 공격을 당하는 순간에는 체력을 회복할 수 없음.
    // 기술이 끊기는 즉시 붕대 감기를 다시 사용하며, 연속 성공 시간이 0으로 초기화.
    // 공격을 받으면 정해진 피해량 만큼 현재 체력이 줄어든다.
    // 현재 체력이 0이하가 되면 캐릭터가 죽으며 더 이상 체력을 회복할 수 없다.
    // 캐릭터의 최대 치력과 몬스터의 공격 패턴이 주어질 때 캐릭터가 끝까지 생존할 수 있는지 궁금
    
    // bandage: [붕대 시전 시간, 초당 회복량, 추가 회복량]이 담겨있음
    // health: 최대 체력
    // attacks: 몬스터의 공격 시간과 피해량
    // 모든 공격이 끝난 직후 남은 체력을 return
    // 공격을 받아 체력이 0이하가 되면 -1 return
    public int solution(int[] bandage, int health, int[][] attacks) {
        int bandTime = bandage[0]; // 시전 시간
        int heal = bandage[1];     // 초당 회복량
        int bonus = bandage[2];    // 추가 회복량
        int hp = health;           // 현재 체력
        int Time = 1;              // 현재 시간
        int piberTime = 0;
        
        for(int i = 0; i < attacks.length; i++) {
            Time += 1;
            
            // 공격 시간이 안됐으면 Time만 추가하고 인덱스 유지
            if(attacks[i][0] != Time) {
                piberTime += 1;
                hp += heal;
                if(piberTime == bandTime) {
                    hp += bonus;
                    piberTime = 0;
                }
                
                i--;
            } else {

                if(attacks[i][0] == Time) {
                    piberTime = 0;
                    hp -= (attacks[i][1]);
                }
            }
            
            // 체력이 최대체력을 넘으면 최대체력으로 교체
            if(health < hp) {
                    hp = health;
                }
            
            // 체력이 0이되면 hp에 -1을 넣어준다.
            if(hp <= 0) {
                hp = -1;
                break;
            }
        }

        return hp;
    }
}