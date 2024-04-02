import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 그냥 큐와 우선순위 큐에 넣는다. (높은 숫자가 우선순위다.)
        // 2. 그냥 큐에서 꺼내서 우선순위 큐 앞에있는거랑 비교한다.
        // 2-1. 같으면 프로세스 실행 
        // 2-2. 같지 않으면 큐에서 꺼낸다음에 다시 큐에 집어 넣자.
        Queue<Pair> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int seq = 1;
        
        for(int i=0; i<priorities.length; i++) {
            Pair p = new Pair(priorities[i], i);
            q.offer(p);
            pq.offer(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            Pair pair = q.peek();
            // 현재 우선순위 값이 우선순위 큐의 가장 첫번째 값보다 크거나 같은 경우
            if(pq.peek() <= pair.getX()) {
                if(pair.getY() == location) {
                    return seq;
                }
                q.poll();
                pq.poll();
                seq++;
            } else {
                q.offer(pair);
                q.poll();
            }
        }
        return seq;
    }
    
    static class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }
}