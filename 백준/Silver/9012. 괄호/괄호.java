import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());
        boolean flag = false;

        for(int i=0; i<num; i++){
            String[] s = br.readLine().split("");

            for(int j =0; j<s.length; j++){
                if(s[j].equals("(")) stack.push(s[j]);
                else {
                    if(stack.size() == 0) {
                        flag = true; 
                        break;
                    }
                    stack.pop();
                }
            }

            if(flag == true || stack.size() != 0){
                System.out.println("NO");
            }else if(flag == false && stack.size() == 0){
                System.out.println("YES");
            }
            flag = false;
            stack.clear();
        }
    }
}
