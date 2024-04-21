class Solution {
    
    static char[] alp = {'A', 'E', 'I', 'O', 'U'};
    static int answer = 0;
    static int count = 0;

    public int solution(String word) {
        rec(0, word, "");
        return answer;
    }
    
    public static void rec(int pos, String word, String tmp) {
        if(word.equals(tmp)) {
            answer = count;
            return ;
        }
        
        if(pos == 5) {
            return ;
        }
        
        for(int i=0; i<5; i++) {
           count++;
           rec(pos+1, word, tmp + String.valueOf(alp[i])); 
        }
    }
}