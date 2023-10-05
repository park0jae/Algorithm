import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            
            else {
                if(!stack.isEmpty()){
                    stack.pop();
                    if(s.charAt(i-1) == '(') ans += stack.size();
                    else ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
