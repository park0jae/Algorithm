class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초동안 붕대를 감으면 1초마다 x의 체력을 회복 -> t * x + y 만큼 회복 (t초동안 다 감으면 보너스 y)
        // 현재 체력이 최대 체력보다 커지는건 안된다.
        
        // 몬스터한테 공격 받아서 0이하면 죽음, 공격 당하면 연속 성공시간 0으로 초기화
        
        // bandage : 기술 시전 시간:t / 초당 회복량:x / 추가 회복량 :y
        // health : 최대 체력 
        // attacks : 몬스터의 공격시간과 피해량 (공격시간, 피해량)
    
        // 연속시간
        int continuous = 0;
        // 마지막 공격 시간
        int lastAttackTime = attacks[attacks.length-1][0];
        int idx = 0;
        int maxHealth = health;
        int skilTime = bandage[0];
        int recoverySecond = bandage[1];
        int plusRecovery = bandage[2];
        int currentAttackTime = attacks[idx][0];
        
        for(int i=1; i<=lastAttackTime; i++) {
            
            // 공격 시간이 되면
            if(i == currentAttackTime) {
                health -= attacks[idx][1];
                // 공격 받았는데 체력 다 달면 죽음
                if(health <= 0) {
                    return -1;
                }
                if(idx + 1 < attacks.length) {
                    idx++;
                    currentAttackTime = attacks[idx][0];
                }
                continuous = 0;
            }
            
            // 공격 받지 않았다
            else {
                continuous++;
                // 지속 시간이 기술 시전시간이 되었을 때
                if(continuous == skilTime) {
                    // 최대 체력 안넘으면 회복
                    if(health+recoverySecond+plusRecovery<= maxHealth) {
                        health += recoverySecond + plusRecovery;
                        // 넘으면 걍 최대로
                    }else {
                        health = maxHealth;
                    }
                    continuous = 0;
                }else {
                     // 체력 변화 (연속 성공 체크) -> 최대 체력 체크       
                    if(health+recoverySecond <= maxHealth) {
                        health += recoverySecond;
                            // 넘으면 걍 최대로
                    }else {
                        health = maxHealth;
                    }     
                }
            }
        }
        int answer = health;
        return answer;
    }
}