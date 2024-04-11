import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int h = 0;
        int w = 0;
        
        for(int[] size : sizes) {
            h = Math.max(h, Math.max(size[0],size[1]));
            w = Math.max(w, Math.min(size[0],size[1]));
        }
        
        return h*w;
    }
}