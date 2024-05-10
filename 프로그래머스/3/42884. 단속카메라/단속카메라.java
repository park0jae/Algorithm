import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
                // (-5,-3), (-14,-5), (-18,-13), (-20, -15)
            }
        });
        int camera = routes[0][1];
        
        for(int i=1; i<routes.length; i++) {
            if(routes[i][0] > camera) {
                answer++;
                camera = routes[i][1];
            }
        }
        
        return answer;
    }
}