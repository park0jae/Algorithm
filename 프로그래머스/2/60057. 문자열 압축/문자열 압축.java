import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;

        // 절반 길이까지만 탐색
        for(int i=1; i<=s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            
            for(int j=i; j<=s.length(); j+=i) {
                int endIdx = Math.min(j+i, s.length());
                String compare = s.substring(j, endIdx);
                
                if(str.equals(compare)) {
                    count++;
                } else {
                    if(count >= 2) {
                        sb.append(count);
                    }
                    sb.append(str);
                    str = compare;
                    count = 1;
                }
            }
            sb.append(str);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}