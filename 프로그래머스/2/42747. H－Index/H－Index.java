import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // n편의 논문 중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 => h의 초ㅣ대가 h-index
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++) {
            if(citations.length - i <= citations[i]) {
                answer = citations.length - i;
                break;
            }
        }
        
        return answer;
    }
}