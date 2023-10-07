import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int lastNum = -1;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String oper = st.nextToken();

            if(oper.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                lastNum = num;
                queue.add(num);
            }
            else if(oper.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else 
                    sb.append(queue.peek()).append("\n");
            }
            else if(oper.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else if(oper.equals("size")){
                sb.append(queue.size()).append("\n");
            }else if(oper.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else {
                    sb.append(lastNum).append("\n");
                }
            }
            else{
                if(queue.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
