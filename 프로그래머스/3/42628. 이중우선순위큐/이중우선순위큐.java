import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 비어있으면 [0,0] , 비어있지 않으면 [최대, 최소]
        
        // 최소, 최대
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")) {
                pqMin.offer(num);
                pqMax.offer(num);
            } else {
                if(pqMin.size() == 0) {
                    continue;
                }
                if(num == 1) {
                    int n = pqMax.poll();
                    pqMin.remove(n);
                    
                }else {
                    int n = pqMin.poll();
                    pqMax.remove(n);
                }
            }
        }
        if(pqMin.size() != 0) {
            return new int[]{pqMax.poll(), pqMin.poll()}; 
        }
        return new int[]{0,0};
    }
}