import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int cur = 0;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
//cur =4
            if(cur < num){
                while(cur < num){
                    stack.push(++cur);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }else {
                if(stack.peek() != num) {
                    System.out.println("NO");
                    System.exit(0);
                }
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}
