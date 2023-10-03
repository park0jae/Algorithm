import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0 이면 
        Stack<Integer> st = new Stack<>();

        int n = sc.nextInt();
        int sum = 0;
        for(int i=0; i<n; i++){
            
            int num = sc.nextInt();

            if(num != 0){
                st.push(num);
            }else {
                st.pop();
            }
        }

        while(!st.empty()){
            sum += st.peek();
            st.pop();
        }
        
        System.out.println(sum);
    }
}
