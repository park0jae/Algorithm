import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String oper = st.nextToken();
            Integer num = 0;
            if(oper.equals("push")){
                num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else {
                if(oper.equals("top")){
                    if(stack.size() == 0) System.out.println(-1);
                    else System.out.println(stack.peek());
                }else if(oper.equals("size")){
                    System.out.println(stack.size());
                }else if(oper.equals("empty")){
                    if(stack.size() == 0) System.out.println(1);
                    else System.out.println(0);
                }else{
                    if(stack.size() == 0) System.out.println(-1);
                    else {
                        System.out.println(stack.peek());
                        stack.pop();
                    }
                }
            }
        }
    }
}
