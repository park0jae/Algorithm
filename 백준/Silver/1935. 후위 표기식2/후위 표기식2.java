import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Double[] arr = new Double[n];
        String s = br.readLine();
        Stack<Double> stack = new Stack<>();

        for(int i=0; i<n; i++){
            arr[i] = Double.valueOf(br.readLine());
        }

        for(int i =0; i<s.length(); i++){
            if('A' <= s.charAt(i) && 'Z' >= s.charAt(i)){
                    stack.push(arr[s.charAt(i)-'A']);
            }
            else {
                double firstNum = stack.pop();
                double secondNum = stack.pop();

                if(s.charAt(i) == '+') {
                    stack.push(firstNum + secondNum);
                }else if(s.charAt(i) == '-') stack.push(secondNum - firstNum);
                else if(s.charAt(i) == '/') stack.push(secondNum / firstNum);
                else stack.push(firstNum * secondNum);    
            }
        }
        System.out.println(String.format("%.2f", stack.peek()));
    }
}
