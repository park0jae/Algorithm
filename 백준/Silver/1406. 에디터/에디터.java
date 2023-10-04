import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<s.length(); i++){
            leftStack.push(s.charAt(i));
        }

        for(int i=0; i<n; i++){

            String command = br.readLine();

            char oper = command.charAt(0);

            switch(oper){
                case 'L':
                    if(!leftStack.isEmpty())
                       rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;

                case 'B': 
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                case 'P': 
                    char alp = command.charAt(2);
                    leftStack.push(alp);
                    break;
            }  
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }
}
