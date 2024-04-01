import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> work = new LinkedList<>();
        List<Integer> release = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            work.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        
        int job = work.poll();
        int count = 1;
        
        while(!work.isEmpty()) {
            // 앞 기능보다 뒤의 기능이 더 늦게 구현되는 케이스 
            if(job < work.peek()) {
                release.add(count);
                count = 1;
                job = work.poll();
            } else {
                count++;
                work.poll();
            }
        }
        release.add(count);
        return release.stream().mapToInt(Integer::intValue).toArray();
    }
}