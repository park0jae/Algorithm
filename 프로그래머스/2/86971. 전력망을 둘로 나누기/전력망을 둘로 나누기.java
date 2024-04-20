import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] visitedCnt;
    
    
    public int solution(int n, int[][] wires) {
        // n : 송전탑 개수, wires : 전선 정보
        // 전선 중 하나를 끊어 송전탑 개수가 비슷하도록 해야함 (절대값 반환)
        
        graph = new ArrayList[n+1];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i= 0; i<wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i = 0; i< wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            visited = new boolean[n+1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1);
            
            int diff = Math.abs(cnt - (n-cnt));
            min = Math.min(min, diff);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return min;
    }
    
    static public int dfs(int start) {
        visited[start] = true;
        int cnt = 1;
        
        for(Integer next : graph[start]) {
            if(!visited[next]) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}