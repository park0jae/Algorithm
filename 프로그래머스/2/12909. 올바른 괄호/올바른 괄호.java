import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        
        if (s.length() % 2 != 0)
            return false;
        
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                if (s.charAt(i) == ')')
                    return false;
                else
                    st.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (!st.isEmpty() && st.peek() == '(')
                        st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
        }
        if (!st.isEmpty())
            answer = false;

        return answer;
    }
}