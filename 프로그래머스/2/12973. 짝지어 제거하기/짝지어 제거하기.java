import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char preAlp = s.charAt(i);
    
            if(st.isEmpty()) {
                st.push(preAlp);
            } else { 
                if(st.peek() == preAlp) {
                    st.pop();
                }else {
                    st.push(preAlp);
                }
            }
        }
        
        answer = st.size() == 0 ? 1:0;
        
        return answer;
    }
}