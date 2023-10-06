import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int totalLen = n - k;

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(!stack.empty()){
                while(!stack.empty() && k > 0 && stack.peek() < s.charAt(i)){
                    stack.pop();
                    k--;
                }
            }
            stack.push(s.charAt(i));
        }
        
        while(totalLen != stack.size()){
            stack.pop();
        }

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse().toString());
    }
}

