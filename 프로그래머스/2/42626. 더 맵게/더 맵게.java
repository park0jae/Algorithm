import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {  
            pq.add(scoville[i]);
        }
        
        while(true) {
            // K이상의 스코빌 지수가 되면 끝
            if(pq.peek() >= K) {
                break;
            }
            int firstLowScoville = pq.peek();
            pq.poll();
            int secondLowScoville = pq.peek();
            pq.poll();
            
            pq.add(firstLowScoville + (secondLowScoville * 2));
            answer++;
            int len = pq.size();
            if(len <2 && pq.peek() <=K) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}