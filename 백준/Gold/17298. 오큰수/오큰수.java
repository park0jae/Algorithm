import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        
        // 오른쪽에 있는 수 중에 큰  수 (그 중 첫번째)
        // 없으면 -1 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        String[] tmp = new String[s.length];

        for(int i=n-1; i>=0; i--){

            int cur = Integer.parseInt(s[i]);

            while(!stack.empty()){
                if(cur < stack.peek()[1]){
                    tmp[i] = String.valueOf(stack.peek()[1]);
                    break;
                }
                stack.pop();
            }

            if(stack.empty()){
                tmp[i] = "-1";
            }

            stack.push(new int[]{i, cur});
            
        }

        for(int i=0; i<tmp.length; i++){
            sb.append(tmp[i]).append(" ");
        }

        System.out.println(sb);
    }
}
