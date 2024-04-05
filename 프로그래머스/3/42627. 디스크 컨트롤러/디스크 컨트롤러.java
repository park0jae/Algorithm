import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 하드디스크는 한 번에 하나의 작업만 수행할 수 있음
        // 평균 시간을 줄이는 방법을 찾아라
        int answer = 0;
        int time = 0;
        int idx = 0;
        
        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        while(!pq.isEmpty() || idx < jobs.length) {
            // 현재 시간보다 요청시간이 작 or 같은  요청시점을 추가
            while(idx < jobs.length && time >= jobs[idx][0]) {
                pq.offer(jobs[idx++]);
            }
            
            // 현재 시간보다 요청시간이 작거나 같은 작업이 없으면 제일 요청시점 빠른애 추가 
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            }
            
            // 큐에 작업 존재 -> 제일 빨리 끝나는애부터 처리
            else {
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
            }
        }
        
        return answer / jobs.length;
    }
}