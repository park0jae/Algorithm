import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 트럭 여러 대가 정해진 순서로 다리를 건넘
        // 다 건너는 최소 시간 구하기
        // 다리에는 최대 bridge_length 대 만큼 올라갈 수 있음
        // weight 이하 무게를 견딜 수 있음 
        int curWeight = 0;
        int time = 0;
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        
        while(true) {
            if(idx == truck_weights.length) {
                time += bridge_length;
                break;
            }
            
            time++;
            int t = truck_weights[idx];
            if(q.size() == bridge_length) {
                curWeight -= q.peek();
                q.poll();
            }
            if(t + curWeight <= weight) {
                q.offer(t);
                curWeight += t;
                idx++;
            } else {
                q.offer(0);
            }
        }
        return time;
    }
}