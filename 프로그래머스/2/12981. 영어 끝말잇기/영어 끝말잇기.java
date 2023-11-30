import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        int where = 0;
        int who = 0;
        int tmpWhere = 0;
        int tmpWho = 0;
        
        List<String> checkWords = new ArrayList<>();
        
        
        for(int i=0; i<words.length; i++) {
            
            if(checkWords.contains(words[i])) {
                who=(i%n)+1;
                where=(i/n)+1;
                break;
            }
            else if(i > 0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length() -1)){
                who=(i%n)+1;
                where=(i/n)+1;
                break;
            }
            checkWords.add(words[i]);
        }
        answer = new int[]{who,where};
        return answer;
    }
}