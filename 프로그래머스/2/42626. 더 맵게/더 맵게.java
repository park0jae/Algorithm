import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 모든 음식의 스코빌 지수를 K 이상으로 ... 
        // 스코빌 지수가 가장 낮은 두 개의 음식을 (가장 맵지 않은 음식 스코빌 + (두번째 안매운 스코빌 * 2)) 짬뽕
        // 모든 음식의 스코빌 지수가 K이상이 될 때까지 반복
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while(true) {
            if(pq.peek() >= K) {
                break;
            }
            
            int firstLow = pq.poll();
            int secondLow = pq.poll();
            
            pq.offer(firstLow + secondLow * 2);
            
            if(pq.size() < 2 && pq.peek() < K) {
                answer = -1;
                break;
            }
            answer++;
        }
        return answer;
    }
}