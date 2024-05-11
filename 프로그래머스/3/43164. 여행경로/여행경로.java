import java.util.*;

class Solution {
    
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] check;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        check = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    static void dfs(int depth, String curPath, String path, String[][] tickets) {
        if(depth == tickets.length) {
            list.add(path);
            return ;
        }
        
        for(int i=0; i< tickets.length; i++) {
            if(!check[i] && curPath.equals(tickets[i][0])) {
                check[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                check[i] = false;
            }
        }
    }
}