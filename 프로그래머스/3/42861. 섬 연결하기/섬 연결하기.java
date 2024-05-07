import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // n개의 섬 사이에 건설하는 비용 costs -> 최소 비용으로 모든 섬이 서로 통행 가능하도록 해야함
        int answer = 0;
        int[] parent = new int[n];
        
        // 부모 자기자신으로 세팅
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        for(int i=0; i<costs.length; i++) {
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
                answer += costs[i][2];
                changeParent(parent, costs[i][0] , costs[i][1]);
            }
        }
        return answer;
    }
    
    public int findParent(int[] parent, int node) {
        if(parent[node] == node) return node;
        return findParent(parent, parent[node]);
    }
    
    public void changeParent(int[] parent, int node1, int node2) {
        int parent1 = findParent(parent, node1);
        int parent2 = findParent(parent, node2);
        
        if(parent1 > parent2) {
            parent[parent2] = parent1;
        } else {
          parent[parent1] = parent2;  
        } 
    }
}