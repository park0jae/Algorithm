import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        
        // AC는 정수 배열에 연산을 하기 위해 만든 언어
        // R(뒤집기) , D(버리기)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<tc; i++){
            Deque<Integer> dq = new LinkedList<>();
            boolean isRight = false;
            boolean isTrue = false;
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            String s = br.readLine();
            String[] tmp = s.substring(1 , s.length() -1).split(",");
            
            if(tmp.length != 0){
                for(String st : tmp){
                    if(!st.equals(""))
                        dq.offer(Integer.valueOf(st));
                }
            }
            

            for(int j=0; j<command.length(); j++){
                if(command.charAt(j) == 'R'){
                    isRight = !isRight;
                }else {
                    if(dq.size() == 0){
                        sb.append("error\n");
                        isTrue = true;
                        break;
                    }
                    if(isRight){
                        dq.removeLast();
                    }else {
                        dq.removeFirst();
                    }
                }
            }
            if(!isTrue){
                sb.append("[");
                while(!dq.isEmpty()){
                    sb.append(isRight ? dq.removeLast() : dq.removeFirst());
                    if(dq.size() != 0){
                        sb.append(",");
                    }
                }    
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
